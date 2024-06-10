package exercise.controller;

import org.junit.jupiter.api.Test;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;

import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }

    private Task createTask() {
        Task task = Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();
        return task;
    }

    // BEGIN
    @Test
    public void testShow() throws Exception {
        Task task = createTask();
        taskRepository.save(task);
        MvcResult result = mockMvc.perform(get("/tasks/" + task.getId()))
                .andExpect(status().isOk())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        assertThat(body).contains(task.getTitle());
        assertThat(body).contains(task.getDescription());
    }

    @Test
    public void testCreate() throws Exception {
        Task task = createTask();
        MockHttpServletRequestBuilder request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(task));
        mockMvc.perform(request)
                .andExpect(status().isCreated());
        Optional<Task> actual = taskRepository.findByTitle(task.getTitle());
        assertThat(actual).isNotEmpty();
        assertThat(task.getTitle()).isEqualTo(actual.get().getTitle());
        assertThat(task.getDescription()).isEqualTo(actual.get().getDescription());
    }

    @Test
    public void testUpdate() throws Exception {
        Task task = createTask();
        taskRepository.save(task);
        Map<String, String> updatedData = Map.of("title", "NewTitle");
        MockHttpServletRequestBuilder request = put("/tasks/" + task.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(updatedData));
        mockMvc.perform(request)
                .andExpect(status().isOk());
        Optional<Task> actual = taskRepository.findById(task.getId());
        assertThat(actual.get().getTitle()).isEqualTo("NewTitle");
    }

    @Test
    public void testDelete() throws Exception {
        Task task = createTask();
        taskRepository.save(task);
        MockHttpServletRequestBuilder request = delete("/tasks/" + task.getId());
        mockMvc.perform(request)
                .andExpect(status().isOk());
        Optional<Task> actual = taskRepository.findById(task.getId());
        assertThat(actual).isEmpty();
    }
    // END
}

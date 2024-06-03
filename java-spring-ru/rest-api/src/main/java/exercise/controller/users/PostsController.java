package exercise.controller.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private static List<Post> posts = Data.getPosts();

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users/{id}/posts")
    public List<Post> index(@PathVariable String id) {
        return posts.stream().filter(p -> id.equals(String.valueOf(p.getUserId()))).toList();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users/{id}/posts")
    public Post create(@PathVariable String id, @RequestBody Post data) {
        data.setUserId(Integer.parseInt(id));
        posts.add(data);
        return data;
    }
}
// END

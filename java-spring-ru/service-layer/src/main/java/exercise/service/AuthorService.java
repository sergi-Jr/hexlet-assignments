package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.model.Author;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository repository;

    @Autowired
    private AuthorMapper mapper;

    public List<AuthorDTO> getAll() {
        List<Author> authors = repository.findAll();
        return authors.stream().map(mapper::map).toList();
    }

    public AuthorDTO getOneById(Long id) {
        Author author = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found:" + id));
        return mapper.map(author);
    }

    public AuthorDTO add(AuthorCreateDTO data) {
        Author model = mapper.map(data);
        repository.save(model);
        return mapper.map(model);
    }

    public AuthorDTO update(Long id, AuthorUpdateDTO data) {
        Author model = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found:" + id));
        mapper.update(data, model);
        repository.save(model);
        return mapper.map(model);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

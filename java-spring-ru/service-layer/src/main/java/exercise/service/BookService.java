package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.model.Book;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository repository;

    @Autowired
    private BookMapper mapper;

    public List<BookDTO> getAll() {
        List<Book> books = repository.findAll();
        return books.stream().map(mapper::map).toList();
    }

    public BookDTO getOneById(Long id) {
        Book book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found:" + id));
        return mapper.map(book);
    }

    public BookDTO add(BookCreateDTO data) {
        Book model = mapper.map(data);
        repository.save(model);
        return mapper.map(model);
    }

    public BookDTO update(Long id, BookUpdateDTO data) {
        Book model = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found:" + id));
        mapper.update(data, model);
        repository.save(model);
        return mapper.map(model);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    // END
}

package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    public Mono<User> getOneById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> add(User user) {
        return userRepository.save(user);
    }

    public Mono<User> update(Long id, User data) {
        return userRepository.findById(id)
                .flatMap(u -> {
                    u.setLastName(data.getLastName());
                    u.setEmail(data.getEmail());
                    u.setFirstName(data.getFirstName());
                    return userRepository.save(u);
                });
    }

    public Mono<Void> delete(Long id) {
        return userRepository.deleteById(id);
    }
    // END
}

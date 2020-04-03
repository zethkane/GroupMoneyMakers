package app.service;

import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
   private UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public Iterable<User> index() {
        return userRepository.findAll();
    }

    public User show(Long id) {
        return userRepository.findById(id).get();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User newUser) {
        User originalUser = userRepository.findById(id).get();
        originalUser.setName(newUser.getName());
        originalUser.setPassword(newUser.getPassword());
        return userRepository.save(originalUser);
    }



    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }

}

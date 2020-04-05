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

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User newUser) {
        User originalUser = userRepository.findById(userId).get();
        originalUser.setName(newUser.getName());
        originalUser.setPassword(newUser.getPassword());
        return userRepository.save(originalUser);
    }



    public Boolean deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return true;
    }

}
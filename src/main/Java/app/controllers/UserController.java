package app.controllers;

import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import app.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> index() {
        return new ResponseEntity<>(service.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.findUserById(id), HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<User> create( @RequestBody User user) {
        return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity<>(service.updateUser(id, user), HttpStatus.OK);
    }
    @DeleteMapping("/users")
    public ResponseEntity<Boolean> destroy(Long id) {
        return new ResponseEntity<>(service.deleteUser(id), HttpStatus.OK);
    }
}
package controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.Optional;

@RestController
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service){ this.service = service;}

    @PostMapping("/user")
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional> show(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

//    @GetMapping("/all")
//    public ResponseEntity<User> showAll(@RequestBody User user){
//        return new ResponseEntity<>(service.findAll(user), HttpStatus.OK);
//    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        return new ResponseEntity<>(service.update(user, id), HttpStatus.OK);
    }

//    @DeleteMapping("/user/{id}")
//    public ResponseEntity<User> destroy(@PathVariable Long id){
//        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
//    }
}

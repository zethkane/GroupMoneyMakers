package controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service){ this.service = service;}

    @PostMapping("/user")
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity<>(service.create(account), HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> show(@PathVariable Integer id){
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<User> showAll(@RequestBody User user){
        return new ResponseEntity<>(service.showAll(user), HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user){
        return new ResponseEntity<>(service.update(id, user), HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> destroy(@PathVariable Integer id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}

package controllers;

import models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.AccountService;

@RestController
public class AccountController {
    private AccountService service;

    @Autowired
    public AccountController(AccountService service) {this.service = service;}

    @PostMapping("/account")
    public ResponseEntity<Account> create(@RequestBody Account account){
     return new ResponseEntity<>(service.createUser(account), HttpStatus.CREATED);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> show(@PathVariable Long id){
        return new ResponseEntity<>(service.findAccountsById(id), HttpStatus.OK);
    }

//    @GetMapping("/account")
//    public ResponseEntity<Account> showAll(@RequestBody Account account){
//        return new ResponseEntity<>(service.showAll(account), HttpStatus.OK);
//    }

//    @PutMapping("/account/{id}")
//    public ResponseEntity<Account> update(@PathVariable Long id, @RequestBody Account account){
//        return new ResponseEntity<>(service.update(id, account), HttpStatus.OK);
//    }

//    @DeleteMapping("/account/{id}")
//    public ResponseEntity<Boolean> destroy(@PathVariable Integer id){
//        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
//    }
}

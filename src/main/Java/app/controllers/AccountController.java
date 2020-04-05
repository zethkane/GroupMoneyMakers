package app.controllers;

import app.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import app.service.AccountService;

@Controller
public class AccountController {
    @Autowired
    private AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/accounts")
    public ResponseEntity<Iterable<Account>> index() {
        return new ResponseEntity<>(service.getAllAccounts(), HttpStatus.OK);
    }
    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.findAccountById(id), HttpStatus.OK);
    }
    @PostMapping("/accounts")
    public ResponseEntity<Account> create(@RequestBody Account account) {
        return new ResponseEntity<>(service.createAccount(account), HttpStatus.CREATED);
    }
    @PutMapping("/accounts")
    public ResponseEntity<Account> update(@PathVariable Long id, @RequestBody Account account) {
        return new ResponseEntity<>(service.updateAccount(id, account), HttpStatus.OK);
    }
    @DeleteMapping("/accounts")
    public ResponseEntity<Boolean> destroy(Long id) {
        return new ResponseEntity<>(service.deleteAccount(id), HttpStatus.OK);
    }
}
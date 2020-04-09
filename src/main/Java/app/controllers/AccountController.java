package app.controllers;

import app.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import app.service.AccountService;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return new ResponseEntity<>(accountService.findAllAccounts(), HttpStatus.OK);
    }
    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.findAccountById(accountId), HttpStatus.OK);
    }
    @PostMapping("/accounts")
    public ResponseEntity<Account> postCreateAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }
    @PutMapping("/accounts/{accountId}")
    public ResponseEntity<Account> putUpdateAccount(@PathVariable Long accountId, @RequestBody Account account) {
        return new ResponseEntity<>(accountService.updateAccount(accountId, account), HttpStatus.OK);
    }
    @DeleteMapping("/accounts/{accountId}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long accountId) {
        return new ResponseEntity<>(accountService.deleteAccount(accountId), HttpStatus.OK);
    }



}

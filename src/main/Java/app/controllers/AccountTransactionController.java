package app.controllers;

import app.models.Account;
import app.service.AccountService;
import app.service.AccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountTransactionController {

    @Autowired
    private AccountTransactionService accountTransactionService;

    public AccountTransactionController(AccountTransactionService accountTransactionService){
        this.accountTransactionService = accountTransactionService;
    }

    @PutMapping("accounts/{accountId}/deposit")
    public ResponseEntity<Double> putDepositToAccount(@PathVariable Long accountId, @RequestParam Double amount){
        return new ResponseEntity<>(accountTransactionService.depositToAccount(accountId,amount), HttpStatus.OK);
    }

    @PutMapping("accounts/{accountId}/withdraw")
    public ResponseEntity<Double> withdraw(@PathVariable Long accountId,@RequestParam Double amount){
        return new ResponseEntity<>(accountTransactionService.withdrawFromAccount(accountId,amount),HttpStatus.OK);
    }

    @PutMapping("accounts/{withdrawalAccountId}/transfer")
    public ResponseEntity<Boolean> transfer(@PathVariable Long withdrawalAccountId, @RequestParam Long depositAccountId ,@RequestParam Double amount){
        return new ResponseEntity<>(accountTransactionService.transfer(withdrawalAccountId,depositAccountId,amount),HttpStatus.OK);
    }
}

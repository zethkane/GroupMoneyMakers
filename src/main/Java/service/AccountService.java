package service;

import models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AccountRepository;


@Service
public class AccountService {
    private AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createUser(Account account) {
        return accountRepository.save(account);
    }

    public Account findAccountsById(Long id) {
        return accountRepository.findById(id).get();
    }


    public Double checkBalance(Long id) {return accountRepository.findById(id).get().getBalance();}

}
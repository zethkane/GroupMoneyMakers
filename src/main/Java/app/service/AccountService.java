package app.service;

import app.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repositories.AccountRepository;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
//change to searching by type
    public Account findAccountById(Long accountId) {
        return accountRepository.findById(accountId).get();
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Long accountId, Account account) {
        Account originalAccount = accountRepository.findById(accountId).get();
        originalAccount.setIsActive(account.getIsActive());
        return accountRepository.save(originalAccount);
    }

    public Boolean deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
        return true;
    }
}
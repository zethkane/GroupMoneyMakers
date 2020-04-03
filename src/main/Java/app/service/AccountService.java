package app.service;

import app.models.Account;
import org.springframework.stereotype.Service;
import app.repositories.AccountRepository;


@Service
public class AccountService {
    private AccountRepository repository;
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Iterable<Account> index() {
        return repository.findAll();
    }

    public Account show(Long id) {
        return repository.findById(id).get();
    }

    public Account create(Account account) {
        return repository.save(account);
    }

    public Account update(Long id, Account newMuffinData) {
        Account originalAccount = repository.findById(id).get();
        originalAccount.setIsActive(newMuffinData.getIsActive());
        return repository.save(originalAccount);
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
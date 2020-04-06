package app.service;

import app.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repositories.AccountRepository;

import java.util.Optional;


@Service
public class AccountService {

    @Autowired
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

    public Account update(Long id, Account account) {
        Account originalAccount = repository.findById(id).get();
        originalAccount.setIsActive(account.getIsActive());
         repository.save(originalAccount);
        return originalAccount;
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
    public Double deposit(Long id, Double depositAmount){
        Account account=repository.findById(id).get();
        Double balance = account.getBalance();
        balance+= depositAmount;
        account.setBalance(balance);
        repository.save(account);
        return balance;

    }

    public Double withdraw(Long id, Double withdrawAmount){
        Account account=repository.findById(id).get();
        Double balance = account.getBalance();
        balance-= withdrawAmount;
        account.setBalance(balance);
        repository.save(account);
        return balance;

    }
    public  Double transfer(Long accountIdFrom, Long accountIdTo,Double amount){
        Account accountFrom =repository.findById(accountIdFrom).get();
        Account accountTo=repository.findById(accountIdTo).get();
        Double accountFromBalance=withdraw(accountIdFrom,amount);
        Double acountToBalance=deposit(accountIdTo,amount);
        return accountFromBalance;

    }




}
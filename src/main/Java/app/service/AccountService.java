package app.service;

//import app.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repositories.AccountRepository;

import java.util.List;


//@Service
//public class AccountService {
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    public AccountService(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }
//
//    public List<Account> findAllAccounts() {
//        return accountRepository.findAll();
//    }
//
//    public Account findAccountById(int accountId) {
//        System.out.println("acctServ");
//        return accountRepository.getOne(accountId);
//    }
//
//    public Account createAccount(Account account) {
//        return accountRepository.save(account);
//    }
//
//    public Account updateAccount(int accountId, Account account) {
//        Account originalAccount = accountRepository.getOne(accountId);
//        originalAccount.setIsActive(account.getIsActive());
//         accountRepository.save(originalAccount);
//        return originalAccount;
//    }
//
//    public Boolean deleteAccount(int accountID) {
//        accountRepository.deleteById(accountID);
//        return true;
//    }
//
//



//}
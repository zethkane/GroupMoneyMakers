package app.service;

import app.models.Account;
import app.models.AccountTransaction;
import app.models.AccountTransactionType;
import app.repositories.AccountRepository;
import app.repositories.AccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountTransactionService {

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Double depositToAccount(Long accountId, Double depositAmount){
        Account account= accountRepository.getOne(accountId);
        AccountTransaction accountTransaction = new AccountTransaction(AccountTransactionType.DEPOSIT, depositAmount);
        accountTransaction.setTransactionBalance(depositAmount);
        account.setBalance(account.getBalance()+accountTransaction.getTransactionBalance());
        accountRepository.save(account);
        return account.getBalance();

    }

    public Double withdrawFromAccount(Long accountId, Double withdrawAmount){
        Account account= accountRepository.getOne(accountId);
        AccountTransaction accountTransaction = new AccountTransaction(AccountTransactionType.WITHDRAWAL, withdrawAmount);
        accountTransaction.setTransactionBalance(withdrawAmount);
        account.setBalance(account.getBalance()-accountTransaction.getTransactionBalance());
        accountRepository.save(account);
        return account.getBalance();

    }
    public Boolean transfer(Long withdrawalAccountId, Long depositAccountId, Double amount){
        withdrawFromAccount(withdrawalAccountId,amount);
        depositToAccount(depositAccountId,amount);
        return true;
    }

    public List<AccountTransaction> getTransactionsByType(AccountTransactionType type){
        return accountTransactionRepository.findByType(type);
    }

    public String getSummaryById(Long accountTransactionId){
        AccountTransaction accountTransaction = accountTransactionRepository.getOne(accountTransactionId);
        return accountTransaction.toString();
    }
}

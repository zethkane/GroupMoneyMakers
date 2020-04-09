package app.service;

import app.models.Account;
import app.models.AccountTransaction;
import app.repositories.AccountRepository;
import app.repositories.AccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTransactionService {

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Double depositToAccount(Long accountId, Double depositAmount){
        Account account= accountRepository.getOne(accountId);
        Double balance = account.getBalance();
        balance+= depositAmount;
        account.setBalance(balance);
        accountRepository.save(account);
        return balance;

    }

    public Double withdrawFromAccount(Long accountId, Double withdrawAmount){
        Account account= accountRepository.getOne(accountId);
        Double balance = account.getBalance();
        balance-= withdrawAmount;
        account.setBalance(balance);
        accountRepository.save(account);
        return balance;

    }
    public  Boolean transfer(Long withdrawalAccountId, Long depositAccountId, Double amount){
        withdrawFromAccount(withdrawalAccountId,amount);
        depositToAccount(depositAccountId,amount);
        return true;

    }
}

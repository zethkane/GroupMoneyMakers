package app.controllers;


import app.Run;
import app.models.Account;
import app.models.Checking;
import app.models.Saving;
import app.service.AccountService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class AccountControllerTest {
    @MockBean
    AccountService accountService;

    AccountController controller;

    @Before
    public void init() {
        this.controller = new AccountController(accountService);

    }

    @Test
    public void index() {
        HttpStatus expected = HttpStatus.OK;

        Saving saving = new Saving();
        saving.setBalance(100.0);

        Checking checking = new Checking();
        checking.setBalance(20.0);
        Set<Account> userAccount = new HashSet<>();
        userAccount.add(saving);
        userAccount.add(checking);

        Iterable<Account> expectedIterable = userAccount;

        Mockito.when(accountService.index()).thenReturn(expectedIterable);
        ResponseEntity<Iterable<Account>> response = controller.index();
        HttpStatus actual = response.getStatusCode();
        Iterable<Account> actualIterable = response.getBody();

        Assert.assertEquals(expected, actual);
        assertEquals(expectedIterable, actualIterable);


    }

    @Test
    public void showTest() {
        HttpStatus expected = HttpStatus.OK;
        Long id = 1L;
        Saving expectedAccount = new Saving();
        expectedAccount.setBalance(100.0);
        expectedAccount.setAccountId(id);

        Mockito.when(accountService.show(1L)).thenReturn(expectedAccount);
        ResponseEntity<Account> response = controller.show(id);
        HttpStatus actual = response.getStatusCode();
        Account actualIterable = response.getBody();

        Assert.assertEquals(expected, actual);
        assertEquals(expectedAccount, actualIterable);

    }

    @Test
    public void createTest() {
        HttpStatus expected = HttpStatus.CREATED;
        Long id = 1L;
        Saving expectedAccount = new Saving();
        expectedAccount.setBalance(100.0);
        expectedAccount.setAccountId(id);

        Mockito.when(accountService.create(expectedAccount)).thenReturn(expectedAccount);
        ResponseEntity<Account> response = controller.create(expectedAccount);
        HttpStatus actual = response.getStatusCode();
        Account actualAccount = response.getBody();

        Assert.assertEquals(expected, actual);
        assertEquals(expectedAccount, actualAccount);


    }

    @Test
    public void updateTest() {
        HttpStatus expected = HttpStatus.OK;
        Long id = 1L;
        Saving expectedAccount = new Saving();
        expectedAccount.setBalance(100.0);
        expectedAccount.setAccountId(id);

        Mockito.when(accountService.update(id, expectedAccount)).thenReturn(expectedAccount);
        ResponseEntity<Account> response = controller.update(id, expectedAccount);
        HttpStatus actual = response.getStatusCode();
        Account actualAccount = response.getBody();

        Assert.assertEquals(expected, actual);
        assertEquals(expectedAccount, actualAccount);


    }


    @Test
    public void deleteTest() {
        HttpStatus expected = HttpStatus.OK;
        Long id = 1L;
        Saving account = new Saving();
        account.setBalance(100.0);
        account.setAccountId(id);
        Boolean expectedDeleted = true;

        Mockito.when(accountService.delete(id)).thenReturn(true);
        ResponseEntity<Boolean> response = controller.destroy(id);
        HttpStatus actual = response.getStatusCode();
        Boolean actualAccount = response.getBody();

        Assert.assertEquals(expected, actual);
        assertEquals(expectedDeleted, actualAccount);


    }

    @Test
    public void depositTest() {
        HttpStatus expected = HttpStatus.OK;
        Long id = 1L;
        Double depositAmount = 10.0;
        Double expectedAmount = 110.0;

        Mockito.when(accountService.deposit(id, depositAmount)).thenReturn(expectedAmount);
        ResponseEntity<Double> response = controller.deposit(id, depositAmount);
        HttpStatus actual = response.getStatusCode();
        Double actualAmount = response.getBody();

        Assert.assertEquals(expected, actual);
        assertEquals(expectedAmount, actualAmount);


    }

    @Test
    public void withdrawTest() {
        HttpStatus expected = HttpStatus.OK;
        Long id = 1L;
        Double withDrawAmount = 10.0;
        Double expectedAmount = 90.0;

        Mockito.when(accountService.withdraw(id, withDrawAmount)).thenReturn(expectedAmount);
        ResponseEntity<Double> response = controller.withdraw(id, withDrawAmount);
        HttpStatus actual = response.getStatusCode();
        Double actualAmount = response.getBody();

        Assert.assertEquals(expected, actual);
        assertEquals(expectedAmount, actualAmount);


    }

}
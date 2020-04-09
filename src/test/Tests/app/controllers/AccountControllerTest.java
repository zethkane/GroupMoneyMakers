package app.controllers;


import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class AccountControllerTest {
//    @MockBean
//    CheckingAccountService checkingAccountService;
//
//    CheckingAccountController controller;
//
//    @Before
//    public void init() {
//        this.controller = new CheckingAccountController(checkingAccountService);
//
//    }
//
//    @Test
//    public void index() {
//        HttpStatus expected = HttpStatus.OK;
//
//        Saving saving = new Saving();
//        saving.setBalance(100.0);
//
//        Checking checking = new Checking();
//        checking.setBalance(20.0);
//        Set<Account> userAccount = new HashSet<>();
//        userAccount.add(saving);
//        userAccount.add(checking);
//
//        Iterable<Account> expectedIterable = userAccount;
//
//        Mockito.when(checkingAccountService.findAllAccounts()).thenReturn(expectedIterable);
//        ResponseEntity<Iterable<Account>> response = controller.index();
//        HttpStatus actual = response.getStatusCode();
//        Iterable<Account> actualIterable = response.getBody();
//
//        Assert.assertEquals(expected, actual);
//        assertEquals(expectedIterable, actualIterable);
//
//
//    }
//
//    @Test
//    public void showTest() {
//        HttpStatus expected = HttpStatus.OK;
//        Long id = 1L;
//        Saving expectedAccount = new Saving();
//        expectedAccount.setBalance(100.0);
//        expectedAccount.setAccountId(id);
//
//        Mockito.when(checkingAccountService.findCheckingAccountById(1L)).thenReturn(expectedAccount);
//        ResponseEntity<Account> response = controller.show(id);
//        HttpStatus actual = response.getStatusCode();
//        Account actualIterable = response.getBody();
//
//        Assert.assertEquals(expected, actual);
//        assertEquals(expectedAccount, actualIterable);
//
//    }
//
//    @Test
//    public void createTest() {
//        HttpStatus expected = HttpStatus.CREATED;
//        Long id = 1L;
//        Saving expectedAccount = new Saving();
//        expectedAccount.setBalance(100.0);
//        expectedAccount.setAccountId(id);
//
//        Mockito.when(checkingAccountService.createCheckingAccount(expectedAccount)).thenReturn(expectedAccount);
//        ResponseEntity<Account> response = controller.create(expectedAccount);
//        HttpStatus actual = response.getStatusCode();
//        Account actualAccount = response.getBody();
//
//        Assert.assertEquals(expected, actual);
//        assertEquals(expectedAccount, actualAccount);
//
//
//    }
//
//    @Test
//    public void updateTest() {
//        HttpStatus expected = HttpStatus.OK;
//        Long id = 1L;
//        Saving expectedAccount = new Saving();
//        expectedAccount.setBalance(100.0);
//        expectedAccount.setAccountId(id);
//
//        Mockito.when(checkingAccountService.updateCheckingAccount(id, expectedAccount)).thenReturn(expectedAccount);
//        ResponseEntity<Account> response = controller.update(id, expectedAccount);
//        HttpStatus actual = response.getStatusCode();
//        Account actualAccount = response.getBody();
//
//        Assert.assertEquals(expected, actual);
//        assertEquals(expectedAccount, actualAccount);
//
//
//    }
//
//
//    @Test
//    public void deleteTest() {
//        HttpStatus expected = HttpStatus.OK;
//        Long id = 1L;
//        Saving account = new Saving();
//        account.setBalance(100.0);
//        account.setAccountId(id);
//        Boolean expectedDeleted = true;
//
//        Mockito.when(checkingAccountService.deleteCheckingAccount(id)).thenReturn(true);
//        ResponseEntity<Boolean> response = controller.destroy(id);
//        HttpStatus actual = response.getStatusCode();
//        Boolean actualAccount = response.getBody();
//
//        Assert.assertEquals(expected, actual);
//        assertEquals(expectedDeleted, actualAccount);
//
//
//    }
//
//    @Test
//    public void depositTest() {
//        HttpStatus expected = HttpStatus.OK;
//        Long id = 1L;
//        Double depositAmount = 10.0;
//        Double expectedAmount = 110.0;
//
//        Mockito.when(checkingAccountService.depositToCheckingAccount(id, depositAmount)).thenReturn(expectedAmount);
//        ResponseEntity<Double> response = controller.deposit(id, depositAmount);
//        HttpStatus actual = response.getStatusCode();
//        Double actualAmount = response.getBody();
//
//        Assert.assertEquals(expected, actual);
//        assertEquals(expectedAmount, actualAmount);
//
//
//    }
//
//    @Test
//    public void withdrawTest() {
//        HttpStatus expected = HttpStatus.OK;
//        Long id = 1L;
//        Double withDrawAmount = 10.0;
//        Double expectedAmount = 90.0;
//
//        Mockito.when(checkingAccountService.withdrawToCheckingAccount(id, withDrawAmount)).thenReturn(expectedAmount);
//        ResponseEntity<Double> response = controller.withdraw(id, withDrawAmount);
//        HttpStatus actual = response.getStatusCode();
//        Double actualAmount = response.getBody();
//
//        Assert.assertEquals(expected, actual);
//        assertEquals(expectedAmount, actualAmount);
//
//
//    }

}
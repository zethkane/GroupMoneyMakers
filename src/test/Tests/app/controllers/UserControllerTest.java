package app.controllers;


import app.Run;
import app.models.Account;
import app.models.Checking;
import app.models.Saving;
import app.models.User;
import app.service.UserService;
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
public class UserControllerTest {
   @MockBean
   UserService userService;

   UserController controller;

   @Before
    public void init (){
       this.controller= new UserController(userService);
   }
    @Test
    public void index() {
        HttpStatus expected = HttpStatus.OK;

        User user = new User();
        user.setName("Kasper");

        User user1 = new User();
        user.setName("Kasper");
        Set<User> users = new HashSet<>();
        users.add(user1);

        Iterable<User> expectedIterable = users;

        Mockito.when(userService.index()).thenReturn(expectedIterable);
        ResponseEntity<Iterable<User>> response = controller.index();
        HttpStatus actual = response.getStatusCode();
        Iterable<User> actualIterable = response.getBody();

        Assert.assertEquals(expected, actual);
        assertEquals(expectedIterable, actualIterable);


    }

    @Test
    public void showTest() {
        HttpStatus expected = HttpStatus.OK;
        Long id = 1L;
        User expectedUser = new User();
        expectedUser.setName("Kasper");
        expectedUser.setId(id);


        Mockito.when(userService.show(1L)).thenReturn(expectedUser);
        ResponseEntity<User> response = controller.show(id);
        HttpStatus actual = response.getStatusCode();
        User actualUser = response.getBody();

        Assert.assertEquals(expected, actual);
        assertEquals(expectedUser, actualUser);

    }
    @Test
    public void updateTest() {
        HttpStatus expected = HttpStatus.OK;
        Long id = 1L;
        User expectedUser = new User();
        expectedUser.setName("Kasper");
        expectedUser.setId(id);

        Mockito.when(userService.update(id, expectedUser)).thenReturn(expectedUser);
        ResponseEntity<User> response = controller.update(id, expectedUser);
        HttpStatus actual = response.getStatusCode();
        User actualUser = response.getBody();

        Assert.assertEquals(expected, actual);
        assertEquals(expectedUser, actualUser);


    }
    @Test
    public void deleteTest() {
        HttpStatus expected = HttpStatus.OK;
        Long id = 1L;
        Saving account = new Saving();
        account.setBalance(100.0);
        account.setAccountId(id);
        Boolean expectedDeleted = true;

        Mockito.when(userService.delete(id)).thenReturn(true);
        ResponseEntity<Boolean> response = controller.destroy(id);
        HttpStatus actual = response.getStatusCode();
        Boolean userDeleted = response.getBody();

        Assert.assertEquals(expected, actual);
        assertEquals(expectedDeleted, userDeleted);


    }
}

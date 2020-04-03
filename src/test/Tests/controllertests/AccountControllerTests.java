package controllertests;

import models.Account;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import service.AccountService;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc

public class AccountControllerTests {

    @MockBean
    private AccountService service;

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    @DisplayName("GET /account/1 - Found")
//    void testGetProjectByIdFound() throws Exception{
//        Account mockAcc = new Account();
//        doReturn(Optional.of(mockAcc)).when(service).findById(1);
//
//        mockMvc.perform(get("/account/{id}", 1))
//                .andExpect(status.isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//        }

}


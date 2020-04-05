package controllertests;

import app.models.Account;
import app.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//
//public class AccountControllerTests {
//
//    @MockBean
//    private AccountService accountService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    @DisplayName("GET /account/1 - Found")
//    void testGetProjectByIdFound() throws Exception{
//        Account mockAcc = new Account();
//        doReturn(Optional.of(mockAcc)).when(accountService).findById(1);
//
//        mockMvc.perform(get("/account/{id}", 1))
//                .andExpect(status.isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//        }
//
//}


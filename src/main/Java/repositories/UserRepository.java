package repositories;

import models.Account;
import models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository <User, Long> {

    User findUserById(Long id);
    List<Account> findAllByAccounts();

}

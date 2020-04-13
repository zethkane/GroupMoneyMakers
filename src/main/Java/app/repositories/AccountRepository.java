package app.repositories;


import app.models.Account;
import org.hibernate.context.spi.AbstractCurrentSessionContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByStatus(Boolean status);
    List<Account> findByNicknameContaining(String nickname);
}



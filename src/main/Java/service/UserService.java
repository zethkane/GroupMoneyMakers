package service;

import models.Account;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AccountRepository;
import repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id)
    {
        return userRepository.findById(id);
    }
    public User update(User user,Long id){
        User updatedUser = userRepository.findUserById(id);
        updatedUser=user;
        return userRepository.save(updatedUser);
    }

    public List<Account> findAll(){
        return userRepository.findAllByAccounts();
    }



}

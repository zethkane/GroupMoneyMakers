package service;

import models.Account;
import models.User;
import repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
    UserRepository userRepository;

    public User create(User user){
        return userRepository.save(user);
    }

    public Optional<User> findbyId(Long id)
    {
        return userRepository.findById(id);
    }
    public User update(User user,Long id){
        User updatedUser = userRepository.findUserById(id);
        updatedUser=user;
        return userRepository.save(user);
    }

    public List<Account> findAll(){
        return userRepository.findAllByAccounts();
    }



}

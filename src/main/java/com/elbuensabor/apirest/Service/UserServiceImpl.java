package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.User;
import com.elbuensabor.apirest.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void createUser(){
        User user = new User("bauti", "1234", "estudiante");
        User user2 = new User ("maximo","JohnWick2001","estudiante");
        User user3 = new User("valentin", "12345", "estudiante");
        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}

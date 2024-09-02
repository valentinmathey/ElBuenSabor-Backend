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
        System.out.println("Username: " + user.getName());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Role: " + user.getRole());
        userRepository.save(user);
    }
}

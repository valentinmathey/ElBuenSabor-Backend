package com.elbuensabor.apirest.Controller;

import com.elbuensabor.apirest.Entity.User;
import com.elbuensabor.apirest.Service.UserService;
import com.elbuensabor.apirest.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    /*
    @Autowired
    UserService userService;

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/findAllUsers")
    List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/CreateUser")
    public String userCreate(){
        userServiceImpl.createUser();
        return "Se creo un nuevo usuario";
    }

     */
}

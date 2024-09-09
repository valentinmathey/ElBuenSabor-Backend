package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.User;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id) throws MiException;
    User createUser(User user) throws MiException;
    User updateUser(Long id, User user) throws MiException;
    void deleteUser(Long id) throws MiException;
}


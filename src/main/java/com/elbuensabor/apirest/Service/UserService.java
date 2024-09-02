package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();
}

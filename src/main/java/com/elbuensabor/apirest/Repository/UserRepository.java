package com.elbuensabor.apirest.Repository;

import com.elbuensabor.apirest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}

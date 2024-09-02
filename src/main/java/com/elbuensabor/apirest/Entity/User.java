package com.elbuensabor.apirest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "USERS")
@Entity
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;


    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }
}

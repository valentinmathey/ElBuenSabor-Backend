package com.elbuensabor.apirest.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;
}

package com.elbuensabor.apirest;

import com.elbuensabor.apirest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApirestApplication.class, args);
		System.out.println("hello world");
	}
}

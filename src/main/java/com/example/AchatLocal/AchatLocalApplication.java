package com.example.AchatLocal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.AchatLocal.Service.RoleService;

@SpringBootApplication
public class AchatLocalApplication {

	@Autowired
	private static RoleService serv;
	
	public static void main(String[] args) {
		SpringApplication.run(AchatLocalApplication.class, args);
		System.out.println(serv.findAll());
	}

}

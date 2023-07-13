package com.example.AchatLocal.Endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AchatLocal.Model.Role;
import com.example.AchatLocal.Service.RoleService;

@RequestMapping("/roles")
@CrossOrigin
@RestController
public class RoleEndpoint {

	@Autowired
	private RoleService serv;
	
	@GetMapping("/")
	public List<Role> findAllRoles(){
		return serv.findAll();
	}
}

package com.example.AchatLocal.Endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("")
	public List<Role> findAllRoles() {
		return serv.findAll();
	}

	@GetMapping("/{id}")
	public Role findRoleById(@PathVariable Integer id) {
		return serv.findById(id);
	}

	@PostMapping("")
	public void saveRole(@RequestBody Role role) {
		serv.saveRole(role);
	}
	
	@PutMapping("")
	public void updateRole(@RequestBody Role role) {
		serv.updateRole(role);
	}
	
	@DeleteMapping("{id}")
	public void deleteRole(@PathVariable Integer id) {
		serv.deleteRole(id);
	}
}

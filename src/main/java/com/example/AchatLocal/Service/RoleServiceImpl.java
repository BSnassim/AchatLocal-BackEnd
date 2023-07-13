package com.example.AchatLocal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.AchatLocal.Model.Role;
import com.example.AchatLocal.Repository.RoleRepository;

public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository repo;

	@Override
	public List<Role> findAll() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public Role findById(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void saveRole(Role role) {
		repo.save(role);
		
	}

	@Override
	public void updateRole(Role role) {
		repo.save(role);
		
	}

	@Override
	public void deleteRole(Integer id) {
		repo.deleteById(id);
		
	}

}

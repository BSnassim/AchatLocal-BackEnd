package com.example.AchatLocal.Service;

import java.util.List;

import com.example.AchatLocal.Model.Role;

public interface RoleService {
	
	public List<Role> findAll();
	public Role findById(Integer id);
	public void saveRole(Role role);
	public void updateRole(Role role);
	public void deleteRole(Integer id);

}

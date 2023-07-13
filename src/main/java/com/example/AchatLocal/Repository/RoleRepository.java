package com.example.AchatLocal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AchatLocal.Model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}

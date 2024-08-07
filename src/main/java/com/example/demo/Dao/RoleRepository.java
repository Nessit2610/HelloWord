package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	public Role findByName(String name);
}

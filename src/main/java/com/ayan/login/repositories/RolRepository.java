package com.ayan.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayan.login.models.Rol;

public interface RolRepository extends JpaRepository<Rol, Short> {
	
}

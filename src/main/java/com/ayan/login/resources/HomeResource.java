package com.ayan.login.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayan.login.models.Rol;
import com.ayan.login.models.User;
import com.ayan.login.repositories.RolRepository;
import com.ayan.login.repositories.UserRepository;

@RestController
public class HomeResource {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RolRepository rolRepository;

	@GetMapping(path = "/")
	public String all() {
		return "<h1>Welcome anonymous</h1>";
	}

	@GetMapping(path = "/user")
	public List<Rol> user() {
		return rolRepository.findAll();
	}

	@GetMapping(path = "/admin")
	public List<User> admin() {
		return userRepository.findAll();
	}

}

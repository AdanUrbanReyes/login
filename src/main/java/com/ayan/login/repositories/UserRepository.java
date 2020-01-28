package com.ayan.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayan.login.models.User;

public interface UserRepository extends JpaRepository<User, String> {

}

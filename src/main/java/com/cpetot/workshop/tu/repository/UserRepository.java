package com.cpetot.workshop.tu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpetot.workshop.tu.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}

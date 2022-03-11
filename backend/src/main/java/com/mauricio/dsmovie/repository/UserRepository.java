package com.mauricio.dsmovie.repository;

import com.mauricio.dsmovie.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
 
    User findByEmail(String email);

}

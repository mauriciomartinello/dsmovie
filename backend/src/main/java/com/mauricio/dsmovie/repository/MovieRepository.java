package com.mauricio.dsmovie.repository;

import com.mauricio.dsmovie.entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}

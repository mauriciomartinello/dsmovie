package com.mauricio.dsmovie.repository;

import com.mauricio.dsmovie.entities.Score;
import com.mauricio.dsmovie.entities.ScorePK;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
    
}

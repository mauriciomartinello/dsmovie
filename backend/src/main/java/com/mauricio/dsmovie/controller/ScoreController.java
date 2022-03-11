package com.mauricio.dsmovie.controller;

import com.mauricio.dsmovie.dto.MovieDTO;
import com.mauricio.dsmovie.dto.ScoreDTO;
import com.mauricio.dsmovie.services.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
    
    @Autowired
    private ScoreService service;

    @PutMapping
    public MovieDTO addScore(@RequestBody ScoreDTO score){
        log.info("ScoreController.addScore - Start - imput: {}", score);
        return service.saveScore(score);
    }
}

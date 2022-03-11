package com.mauricio.dsmovie.services;

import com.mauricio.dsmovie.dto.MovieDTO;
import com.mauricio.dsmovie.dto.ScoreDTO;
import com.mauricio.dsmovie.entities.Movie;
import com.mauricio.dsmovie.entities.Score;
import com.mauricio.dsmovie.entities.User;
import com.mauricio.dsmovie.repository.MovieRepository;
import com.mauricio.dsmovie.repository.ScoreRepository;
import com.mauricio.dsmovie.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
public class ScoreService {
    
    @Autowired
    private MovieRepository movieRep;

    @Autowired
    private UserRepository userRep;

    @Autowired
    private ScoreRepository scoreRep;

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO){
        User user = userRep.findByEmail(scoreDTO.getEmail());
        if(ObjectUtils.isEmpty(user)){
            user = userRep.saveAndFlush(User.builder().email(scoreDTO.getEmail()).build());
        }
        Movie movie = movieRep.findById(scoreDTO.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore());
        score = scoreRep.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()){
            sum = sum + s.getValue();
        }
        double avg = sum/movie.getScores().size();
        movie.setScore(avg);
        movie.setCount(movie.getScores().size());
        return new MovieDTO(movieRep.save(movie));
    }
}

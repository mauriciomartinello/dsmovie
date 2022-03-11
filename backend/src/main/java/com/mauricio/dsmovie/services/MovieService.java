package com.mauricio.dsmovie.services;

import java.util.Optional;

import com.mauricio.dsmovie.dto.MovieDTO;
import com.mauricio.dsmovie.entities.Movie;
import com.mauricio.dsmovie.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRep;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable){
        Page<Movie> result = movieRep.findAll(pageable);
        Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
        return page;
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){
        Optional<Movie> result = movieRep.findById(id);
        if(result.isPresent())
            return new MovieDTO(result.get());
        else
            throw new RuntimeException("Movie não encontrado");
    }

}

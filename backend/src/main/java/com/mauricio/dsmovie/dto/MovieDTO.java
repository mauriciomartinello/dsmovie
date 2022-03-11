package com.mauricio.dsmovie.dto;

import com.mauricio.dsmovie.entities.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieDTO {
    private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;

    public MovieDTO(Movie movie){
        id = movie.getId();
        title = movie.getTitle();
        score = movie.getScore();
        count = movie.getCount();
        image = movie.getImage();
    }

}
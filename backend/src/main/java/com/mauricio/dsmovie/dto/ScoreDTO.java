package com.mauricio.dsmovie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScoreDTO {

    private long movieId;
    private String email;
    private Double score;
    
}

package com.jaanussinivali.cinemaback.util;

import lombok.*;

@Builder
@Getter
@Setter
@Data
public class GenreFrequency {

    private Integer frequency;
    private String genreName;

    public GenreFrequency(Integer frequency, String genreName) {

        this.frequency = frequency;
        this.genreName = genreName;
    }
}

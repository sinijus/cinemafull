package com.jaanussinivali.cinemaback.dto;

import com.jaanussinivali.cinemaback.model.Screening;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO for {@link Screening}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreeningResponse implements Serializable {
    private Integer id;
    private Integer movieId;
    private String movieTitle;
    private Integer movieReleaseYear;
    private String hallName;
    @NotNull
    private LocalDate date;
    @NotNull
    private LocalTime time;
}
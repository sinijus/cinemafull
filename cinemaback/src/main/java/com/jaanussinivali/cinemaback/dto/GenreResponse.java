package com.jaanussinivali.cinemaback.dto;

import com.jaanussinivali.cinemaback.model.Genre;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Genre}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreResponse implements Serializable {
    private Integer genreId;
    @NotNull
    @Size(max = 255)
    private String genreName;
}
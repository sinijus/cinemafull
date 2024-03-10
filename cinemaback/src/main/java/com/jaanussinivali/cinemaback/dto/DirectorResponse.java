package com.jaanussinivali.cinemaback.dto;

import com.jaanussinivali.cinemaback.model.Director;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Director}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorResponse implements Serializable {
    private Integer directorId;
    @NotNull
    @Size(max = 255)
    private String directorName;
}
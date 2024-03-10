package com.jaanussinivali.cinemaback.dto;

import com.jaanussinivali.cinemaback.model.Restriction;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Restriction}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestrictionResponse implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String name;
}
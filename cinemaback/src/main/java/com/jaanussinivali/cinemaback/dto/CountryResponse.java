package com.jaanussinivali.cinemaback.dto;

import com.jaanussinivali.cinemaback.model.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Country}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponse implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String name;
}
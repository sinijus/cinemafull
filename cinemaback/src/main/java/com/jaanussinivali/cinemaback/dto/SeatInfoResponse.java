package com.jaanussinivali.cinemaback.dto;

import com.jaanussinivali.cinemaback.model.Seat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Seat}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatInfoResponse implements Serializable {
    @NotNull
    private Integer row;
    @NotNull
    private Integer number;
}
package com.jaanussinivali.cinemaback.dto;

import com.jaanussinivali.cinemaback.model.Seat;
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
public class SeatResponse implements Serializable {
    private Integer id;
    private Boolean available;
}
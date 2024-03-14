package com.jaanussinivali.cinemaback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Reservation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse implements Serializable {
    private Integer id;
}
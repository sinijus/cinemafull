package com.jaanussinivali.cinemaback.dto;

import com.jaanussinivali.cinemaback.model.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Seat}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatReservationResponse implements Serializable {
    private List<Integer> seatIds;
    private List<List<SeatResponse>> hall;
}
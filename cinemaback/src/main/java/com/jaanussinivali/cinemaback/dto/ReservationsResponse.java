package com.jaanussinivali.cinemaback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationsResponse implements Serializable {
    private List<SeatInfoResponse> reservedSeats;
    private ScreeningInfoResponse screeningInfo;
}

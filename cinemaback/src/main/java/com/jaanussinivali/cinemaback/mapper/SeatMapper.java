package com.jaanussinivali.cinemaback.mapper;

import com.jaanussinivali.cinemaback.model.Seat;
import com.jaanussinivali.cinemaback.dto.SeatResponse;
import com.jaanussinivali.cinemaback.dto.SeatInfoResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SeatMapper {

    SeatResponse toSeatResponse(Seat seat);

    List<SeatResponse> toSeatsResponse(List<Seat> seats);

    SeatInfoResponse toSeatReservationResponse(Seat seat);
    List<SeatInfoResponse> toSeatsReservationResponse(List<Seat> seats);

}
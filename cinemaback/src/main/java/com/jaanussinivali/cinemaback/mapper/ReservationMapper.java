package com.jaanussinivali.cinemaback.mapper;

import com.jaanussinivali.cinemaback.model.Reservation;
import com.jaanussinivali.cinemaback.dto.ReservationResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {
    ReservationResponse toReservationResponse(Reservation reservation);
}
package com.jaanussinivali.cinemaback.model;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {
    ReservationResponse toReservationResponse(Reservation reservation);
}
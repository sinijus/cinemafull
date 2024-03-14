package com.jaanussinivali.cinemaback.mapper;

import com.jaanussinivali.cinemaback.model.Seat;
import com.jaanussinivali.cinemaback.dto.SeatResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SeatMapper {

    SeatResponse toSeatResponse(Seat seat);


}
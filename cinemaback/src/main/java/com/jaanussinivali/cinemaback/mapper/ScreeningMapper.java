package com.jaanussinivali.cinemaback.mapper;

import com.jaanussinivali.cinemaback.dto.ScreeningResponse;
import com.jaanussinivali.cinemaback.model.Screening;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScreeningMapper {

    @Mapping(source = "hall.name", target = "hallName")
    @Mapping(source = "movie.releaseYear", target = "movieReleaseYear")
    @Mapping(source = "movie.title", target = "movieTitle")
    @Mapping(source = "movie.id", target = "movieId")
    ScreeningResponse toScreeningResponse(Screening screening);

    List<ScreeningResponse> toScreeningsResponse(List<Screening> screenings);

}
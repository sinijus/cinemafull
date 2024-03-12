package com.jaanussinivali.cinemaback.mapper;

import com.jaanussinivali.cinemaback.dto.ScreeningInfoResponse;
import com.jaanussinivali.cinemaback.dto.ScreeningListResponse;
import com.jaanussinivali.cinemaback.model.Screening;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScreeningMapper {

    @Mapping(source = "hall.name", target = "hallName")
    @Mapping(source = "movie.releaseYear", target = "movieReleaseYear")
    @Mapping(source = "movie.title", target = "movieTitle")
    @Mapping(source = "movie.id", target = "movieId")
    ScreeningListResponse toScreeningListResponse(Screening screening);

    @Mapping(source = "hall.name", target = "hallName")
    @Mapping(source = "movie.releaseYear", target = "movieReleaseYear")
    @Mapping(source = "movie.description", target = "movieDescription")
    @Mapping(source = "movie.length", target = "movieLength")
    @Mapping(source = "movie.title", target = "movieTitle")
    @Mapping(source = "movie.id", target = "movieId")
    ScreeningInfoResponse toScreeningInfoResponse(Screening screening);

}
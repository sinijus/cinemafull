package com.jaanussinivali.cinemaback.mapper;

import com.jaanussinivali.cinemaback.model.Genre;
import com.jaanussinivali.cinemaback.dto.GenreResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreMapper {


    GenreResponse toGenreResponse(Genre genre);
    List<GenreResponse> toGenresResponse(List<Genre> genres);

}
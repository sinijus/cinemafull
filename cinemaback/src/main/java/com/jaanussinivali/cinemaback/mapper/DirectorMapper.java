package com.jaanussinivali.cinemaback.mapper;

import com.jaanussinivali.cinemaback.model.Director;
import com.jaanussinivali.cinemaback.dto.DirectorResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DirectorMapper {

    DirectorResponse toDirectorResponse (Director director);
    List<DirectorResponse> toDirectorsResponse (List<Director> directors);

}
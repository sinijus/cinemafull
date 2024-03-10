package com.jaanussinivali.cinemaback.mapper;

import com.jaanussinivali.cinemaback.model.Restriction;
import com.jaanussinivali.cinemaback.dto.RestrictionResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestrictionMapper {


    RestrictionResponse toRestrictionResponse(Restriction restriction);

    List<RestrictionResponse> toRestrictionsResponse(List<Restriction> restrictions);

}
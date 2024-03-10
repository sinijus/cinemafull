package com.jaanussinivali.cinemaback.mapper;

import com.jaanussinivali.cinemaback.model.Country;
import com.jaanussinivali.cinemaback.dto.CountryResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryMapper {


    CountryResponse toCountryResponse(Country country);

    List<CountryResponse> toCountriesResponse(List<Country> countries);

}
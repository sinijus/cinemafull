package com.jaanussinivali.cinemaback.mapper;

import com.jaanussinivali.cinemaback.dto.LanguageResponse;
import com.jaanussinivali.cinemaback.model.Language;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LanguageMapper {


    LanguageResponse toLanguageResponse(Language language);
    List<LanguageResponse> toLanguagesResponse(List<Language> languages);

}
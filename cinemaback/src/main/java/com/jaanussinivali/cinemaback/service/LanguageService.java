package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.Language;
import com.jaanussinivali.cinemaback.repository.LanguageRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
    @Resource
    private LanguageRepository languageRepository;

    public List<Language> findAllLanguages() {
        return languageRepository.findAll();
    }
}

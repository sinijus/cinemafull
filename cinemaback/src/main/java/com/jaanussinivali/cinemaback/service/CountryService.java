package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.Country;
import com.jaanussinivali.cinemaback.repository.CountryRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Resource
    private CountryRepository countryRepository;

    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }

}

package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
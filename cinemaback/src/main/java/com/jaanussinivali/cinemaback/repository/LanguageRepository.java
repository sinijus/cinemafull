package com.jaanussinivali.cinemaback.repository;

import com.jaanussinivali.cinemaback.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
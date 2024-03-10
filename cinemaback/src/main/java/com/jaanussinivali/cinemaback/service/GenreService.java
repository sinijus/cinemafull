package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.Genre;
import com.jaanussinivali.cinemaback.repository.GenreRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Resource
    private GenreRepository genreRepository;

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }
}

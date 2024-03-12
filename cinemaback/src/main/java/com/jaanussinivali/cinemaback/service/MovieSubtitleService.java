package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.MovieSubtitle;
import com.jaanussinivali.cinemaback.repository.MovieSubtitleRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieSubtitleService {
    @Resource
    private MovieSubtitleRepository movieSubtitleRepository;
    public List<MovieSubtitle> findMovieSubtitlesByMovieId(Integer movieId) {
        return movieSubtitleRepository.findMovieSubtitlesByMovieId(movieId);
    }
}

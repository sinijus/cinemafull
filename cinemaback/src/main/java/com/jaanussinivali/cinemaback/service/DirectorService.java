package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.Director;
import com.jaanussinivali.cinemaback.repository.DirectorRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    @Resource
    DirectorRepository directorRepository;
    public List<Director> findAllDirectors() {
        return directorRepository.findAll();
    }
}

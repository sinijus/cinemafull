package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.exception.DirectorNotFoundException;
import com.jaanussinivali.cinemaback.model.Director;
import com.jaanussinivali.cinemaback.repository.DirectorRepository;
import com.jaanussinivali.cinemaback.util.ErrorMessage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    @Resource
    DirectorRepository directorRepository;

    public List<Director> findAllDirectors() {
        return directorRepository.findAll();
    }

    public Director findDirectorById(Integer id) {
        Optional<Director> directorOptional = directorRepository.findById(id);
        if (directorOptional.isEmpty()) {
            throw new DirectorNotFoundException(ErrorMessage.DIRECTOR_NOT_FOUND.getMessage());
        } else {
            return directorOptional.get();
        }
    }
}

package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.Restriction;
import com.jaanussinivali.cinemaback.repository.RestrictionRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestrictionService {
    @Resource
    private RestrictionRepository restrictionRepository;

    public List<Restriction> findAllRestrictions() {
        return restrictionRepository.findAll();
    }
}
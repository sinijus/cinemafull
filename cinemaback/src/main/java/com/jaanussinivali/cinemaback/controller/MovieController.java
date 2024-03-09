package com.jaanussinivali.cinemaback.controller;

import com.jaanussinivali.cinemaback.service.MovieService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Resource
    private MovieService movieService;





}

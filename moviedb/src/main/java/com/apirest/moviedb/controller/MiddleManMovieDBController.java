package com.apirest.moviedb.controller;


import com.apirest.moviedb.entity.Genre;
import com.apirest.moviedb.service.MiddleManMovieDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MiddleManMovieDBController {

    @Autowired
    MiddleManMovieDBService middleManMovieDBService;
    @GetMapping("api/genre/movie/list")
    //public List<Genre> getAllGenre(){
    public void getAllGenre(){

        middleManMovieDBService.findAllGenreMovieList();
    }

}

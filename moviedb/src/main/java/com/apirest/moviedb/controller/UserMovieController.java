package com.apirest.moviedb.controller;

import com.apirest.moviedb.entity.UserMovie;
import com.apirest.moviedb.service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserMovieController {
    @Autowired
    UserMovieService userMovieService;

    @GetMapping("/api/movie/{movie_id}/favorite")
    public boolean getFavorite(@PathVariable int movie_id){
        return userMovieService.findFavorites(1,movie_id);
    }
}

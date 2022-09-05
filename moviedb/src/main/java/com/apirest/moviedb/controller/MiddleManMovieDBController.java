package com.apirest.moviedb.controller;


import com.apirest.moviedb.entity.Genres;
import com.apirest.moviedb.entity.Movie;
import com.apirest.moviedb.service.MiddleManMovieDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class MiddleManMovieDBController {

    @Autowired
    MiddleManMovieDBService middleManMovieDBService;
    @GetMapping("api/genre/movie/list")
    public List<Genres> getAllGenres() throws IOException {

        return middleManMovieDBService.findAllGenreMovieList();
    }
    @GetMapping("api/movie/popular")
    public List<Movie> getPopularMovies() throws IOException {
        return middleManMovieDBService.findPopularMovies();
    }
    @GetMapping("api/movie/top_rated")
    public List<Movie> getTopRatedMovies() throws IOException {
        return middleManMovieDBService.findPopularMovies();
    }
    @GetMapping("api/movie/{movie_id}")
    public List<Movie> getMoviesById(@PathVariable Integer movie_id) throws IOException {
        return middleManMovieDBService.findMovieById(movie_id);
    }


}

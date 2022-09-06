package com.apirest.moviedb.controller;


import com.apirest.moviedb.entity.*;
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
        return middleManMovieDBService.findTopRatedMovies();
    }
    @GetMapping("api/movie/{movie_id}")
    public Movie getMoviesById(@PathVariable Integer movie_id) throws IOException {
        return middleManMovieDBService.findMovieById(movie_id);
    }
    @GetMapping("api/movie/{movie_id}/credits")
    public List<CastAndCrew> getCastAndCrewMovieById(@PathVariable Integer movie_id) throws IOException {
        return middleManMovieDBService.findCastAndCrewMovieById(movie_id);
    }
    @GetMapping("api/movie/{movie_id}/images")
    public List<Image> getImagesForMovieById(@PathVariable Integer movie_id) throws IOException {
        return middleManMovieDBService.findAllImagesForMovieById(movie_id);
    }
    @GetMapping("api/movie/{movie_id}/keywords")
    public List<Keywords> getKeywordsForMovieById(@PathVariable Integer movie_id) throws IOException {
        return middleManMovieDBService.findAllKeywordsForMovieById(movie_id);
    }
    @GetMapping("api/movie/{movie_id}/recommendations")
    public List<Movie> getRecommendationsForMovieById(@PathVariable Integer movie_id) throws IOException {
        return middleManMovieDBService.findRecommendationsForMovieById(movie_id);
    }
    @GetMapping("api/movie/{movie_id}/similar")
    public List<Movie> getSimilarMovieById(@PathVariable Integer movie_id) throws IOException {
        return middleManMovieDBService.findSimilarMovieById(movie_id);
    }
}

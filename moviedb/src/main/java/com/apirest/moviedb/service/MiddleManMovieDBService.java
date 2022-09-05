package com.apirest.moviedb.service;

import com.apirest.moviedb.entity.Genre;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MiddleManMovieDBService {
    final String uri = "https://api.themoviedb.org/3/";
    RestTemplate restTemplate = new RestTemplate();
    final String apiKey = "949f7ad927a01a36a739c336dd6449b9";

    public void findAllGenreMovieList(){

        System.out.println(restTemplate.getForObject(uri+"genre/movie/list"+"?api_key="+apiKey, Genre.class));

        //Object[] response = restTemplate.getForObject(uri+"/genre/movie/list"+"?api_key="+apiKey, Object[].class);



    }

}

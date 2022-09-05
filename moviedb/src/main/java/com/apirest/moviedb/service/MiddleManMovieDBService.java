package com.apirest.moviedb.service;

import com.apirest.moviedb.entity.Genres;
import com.apirest.moviedb.entity.Movie;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class MiddleManMovieDBService {
    final String uri = "https://api.themoviedb.org/3/";
    final String apiKey = "949f7ad927a01a36a739c336dd6449b9";

    public List<Genres> findAllGenreMovieList() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(uri+"genre/movie/list?api_key="+apiKey);

        InputStream input = url.openStream();
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        StringBuilder json = new StringBuilder();
        int c ;
        while((c= reader.read())!=-1){
            json.append((char)c);
        }

        Genres[] response  = mapper.readValue(mapper.readTree(json.toString()).get("genres").toString(),Genres[].class);

        return Arrays.asList(response);

    }

    public List<Movie> findPopularMovies(){
        return null;
    }

}

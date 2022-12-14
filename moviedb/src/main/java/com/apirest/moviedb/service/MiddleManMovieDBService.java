package com.apirest.moviedb.service;

import com.apirest.moviedb.entity.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

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
    private ObjectMapper mapper;
    private StringBuilder json;

    public List<Genres> findAllGenreMovieList() throws IOException {
        StringBuilder jsonReq = getStringFromRequest("genre/movie/list?api_key=");
        Genres[] response  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("genres").toString(),Genres[].class);
        return Arrays.asList(response);
    }

    public List<Movie> findPopularMovies() throws IOException {
        StringBuilder jsonReq = getStringFromRequest("movie/popular?api_key=");
        Movie[] response  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("results").toString(),Movie[].class);
        return Arrays.asList(response);
    }

    public List<Movie> findTopRatedMovies() throws IOException {
        StringBuilder jsonReq = getStringFromRequest("movie/top_rated?api_key=");
        Movie[] response  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("results").toString(),Movie[].class);
        return Arrays.asList(response);
    }

    public Movie findMovieById(Integer id) throws IOException {
        System.out.println(id.toString());
        StringBuilder jsonReq = getStringFromRequest("movie/"+id.toString()+"?api_key=");
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
        Movie response  = mapper.readValue(jsonReq.toString(),Movie.class);
        return response;
    }

    public CastAndCrew findCastAndCrewMovieById(Integer movie_id) throws IOException {
        StringBuilder jsonReq = getStringFromRequest("movie/"+movie_id.toString()+"/credits?api_key=");
        Cast[] responseCast  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("cast").toString(),Cast[].class);
        Crew[] responseCrew  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("crew").toString(),Crew[].class);
        CastAndCrew response = new CastAndCrew();

        response.setCasts(Arrays.asList(responseCast));
        response.setCrews(Arrays.asList(responseCrew));

        return response;
    }
    public BackgroundLogosPosters findAllImagesForMovieById(Integer movie_id) throws IOException {
        StringBuilder jsonReq = getStringFromRequest("movie/"+movie_id.toString()+"/images?api_key=");

        System.out.println(mapper.readTree(jsonReq.toString()).get("id"));

        Image[] responseBackdrops  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("backdrops").toString(),Image[].class);
        Image[] responsePosters  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("posters").toString(),Image[].class);
        int id = mapper.readTree(jsonReq.toString()).get("id").asInt();

        BackgroundLogosPosters response = new BackgroundLogosPosters();
        response.setBackground(Arrays.asList(responseBackdrops));
        response.setPosters(Arrays.asList(responsePosters));
        response.setId(id);
        return response;
    }
    public List<Keywords> findAllKeywordsForMovieById(Integer movie_id) throws IOException {
        StringBuilder jsonReq = getStringFromRequest("movie/"+movie_id.toString()+"/keywords?api_key=");
        Keywords[] response  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("keywords").toString(),Keywords[].class);
        return Arrays.asList(response);

    }
    public List<Movie> findRecommendationsForMovieById(Integer movie_id) throws IOException {
        StringBuilder jsonReq = getStringFromRequest("movie/"+movie_id.toString()+"/recommendations?api_key=");
        Movie[] response  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("results").toString(),Movie[].class);
        return Arrays.asList(response);
    }
    public List<Movie> findSimilarMovieById(Integer movie_id) throws IOException {
        StringBuilder jsonReq = getStringFromRequest("movie/"+movie_id.toString()+"/similar?api_key=");
        Movie[] response  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("results").toString(),Movie[].class);
        return Arrays.asList(response);
    }
    private StringBuilder getStringFromRequest(String req) throws IOException {
        mapper = new ObjectMapper();
        URL url = new URL(uri+req+apiKey);

        InputStream input = url.openStream();
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        json = new StringBuilder();
        int c ;
        while((c= reader.read())!=-1){
            json.append((char)c);
        }
        return json;
    }
}

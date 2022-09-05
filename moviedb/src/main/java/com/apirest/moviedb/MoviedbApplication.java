package com.apirest.moviedb;

import com.apirest.moviedb.entity.Genres;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MoviedbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviedbApplication.class, args);
	}





}

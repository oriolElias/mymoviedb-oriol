package com.apirest.moviedb.service;

import com.apirest.moviedb.entity.UserMovie;
import com.apirest.moviedb.repository.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserMovieService {
    @Autowired
    private UserMovieRepository userMovieRepository;

    public Boolean findFavorites(Integer userid,Integer movieid){
        UserMovie b = userMovieRepository.findByUseridAndMovieid(userid,movieid).get();

        return b.isFavorite();
    }

    public Integer findPersonalRating(Integer userid,Integer movieid){
        UserMovie b = userMovieRepository.findByUseridAndMovieid(userid,movieid).get();

        return b.getPersonal_rating();
    }

    public String findNotes(Integer userid,Integer movieid){
        UserMovie b = userMovieRepository.findByUseridAndMovieid(userid,movieid).get();

        return b.getNotes();
    }

}

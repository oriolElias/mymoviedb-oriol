package com.apirest.moviedb.entity;

import javax.persistence.*;

@Entity
public class UserMovie {

    @ManyToOne
    @JoinColumn(name="userid")
    private Users userid;

    @Id
    private int movieid;

    private boolean favorite;
    private int personal_rating;
    private String notes;

    @Override
    public String toString() {
        return "UserMovie{" +
                "user=" + userid +
                ", movieid=" + movieid +
                ", favorite=" + favorite +
                ", personal_rating=" + personal_rating +
                ", notes='" + notes + '\'' +
                '}';
    }

    public Users getUser() {
        return userid;
    }

    public void setUser(Users user) {
        this.userid = user;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getPersonal_rating() {
        return personal_rating;
    }

    public void setPersonal_rating(int personal_rating) {
        this.personal_rating = personal_rating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public UserMovie() {
    }

    public UserMovie(Users user, int movieid, boolean favorite, int personal_rating, String notes) {
        this.userid = user;
        this.movieid = movieid;
        this.favorite = favorite;
        this.personal_rating = personal_rating;
        this.notes = notes;
    }
}

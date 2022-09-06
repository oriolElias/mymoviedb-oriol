package com.apirest.moviedb.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BackgroundLogosPosters {
    private List<Image> background;
    private int id;
    private List<Image> posters;

    @Override
    public String toString() {
        return "BackgroundLogosPosters{" +
                "background=" + background +
                ", id=" + id +
                ", posters=" + posters +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Image> getBackground() {
        return background;
    }

    public void setBackground(List<Image> background) {
        this.background = background;
    }



    public List<Image> getPosters() {
        return posters;
    }

    public void setPosters(List<Image> posters) {
        this.posters = posters;
    }

    public BackgroundLogosPosters() {
    }

    public BackgroundLogosPosters(List<Image> background, int id, List<Image> posters) {
        this.background = background;
        this.id = id;
        this.posters = posters;
    }
}

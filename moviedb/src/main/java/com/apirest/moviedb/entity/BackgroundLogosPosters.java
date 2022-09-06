package com.apirest.moviedb.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BackgroundLogosPosters {
    private List<Image> background;
    private List<Image> logos;
    private List<Image> posters;

    @Override
    public String toString() {
        return "BackgroundLogosPosters{" +
                "background=" + background +
                ", logos=" + logos +
                ", posters=" + posters +
                '}';
    }

    public List<Image> getBackground() {
        return background;
    }

    public void setBackground(List<Image> background) {
        this.background = background;
    }

    public List<Image> getLogos() {
        return logos;
    }

    public void setLogos(List<Image> logos) {
        this.logos = logos;
    }

    public List<Image> getPosters() {
        return posters;
    }

    public void setPosters(List<Image> posters) {
        this.posters = posters;
    }

    public BackgroundLogosPosters() {
    }

    public BackgroundLogosPosters(List<Image> background, List<Image> logos, List<Image> posters) {
        this.background = background;
        this.logos = logos;
        this.posters = posters;
    }
}

package com.movieinfo.app.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieList {

    private List<MovieResponse> results;

    public MovieList(List<MovieResponse> results) {
        this.results = results;
    }

    public MovieList() {}

    public List<MovieResponse> getResults() { return results; }

    public void setResults(List<MovieResponse> results) {
        this.results = results;
    }
}

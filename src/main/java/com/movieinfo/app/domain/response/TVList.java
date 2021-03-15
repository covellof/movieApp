package com.movieinfo.app.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TVList {

    private List<TVResponse> results;

    public TVList(){}

    public List<TVResponse> getResults() { return results; }

    public void setResults(List<TVResponse> results) { this.results = results; }
}

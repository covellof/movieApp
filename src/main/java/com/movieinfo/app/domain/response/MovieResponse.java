package com.movieinfo.app.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.movieinfo.app.domain.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieResponse {

    private Integer id;
    private MovieCollection belongs_to_collection;
    private long budget;
    private String original_title;
    private String overview;
    private long popularity;
    private List<ProductionCompany> production_companies;
    private String release_date;
    private int runtime;
    private List<SpokenLanguage> spoken_languages;
    private String tagline;
    private String title;
    private float vote_average;
    private long vote_count;
    private long revenue;
    private boolean success;
    private boolean adult;
    private String backdrop_path;
    private boolean video;
    private String status;
    private List<ProductionCountry> production_countries;
    private String poster_path;
    private List<Genre> genres;
    private String homepage;
    private String imdb_id;
    private String original_language;

    public MovieResponse() {}

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public MovieCollection getBelongs_to_collection() { return belongs_to_collection; }

    public void setBelongs_to_collection(MovieCollection belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public long getBudget() { return budget; }

    public void setBudget(long budget) { this.budget = budget; }

    public String getOriginal_title() { return original_title; }

    public void setOriginal_title(String original_title) { this.original_title = original_title; }

    public String getOverview() { return overview; }

    public void setOverview(String overview) { this.overview = overview; }

    public long getPopularity() { return popularity; }

    public void setPopularity(long popularity) { this.popularity = popularity; }

    public List<ProductionCompany> getProduction_companies() { return production_companies; }

    public void setProduction_companies(List<ProductionCompany> production_companies) {
        this.production_companies = production_companies;
    }

    public String getRelease_date() { return release_date; }

    public void setRelease_date(String release_date) { this.release_date = release_date; }

    public int getRuntime() { return runtime; }

    public void setRuntime(int runtime) { this.runtime = runtime; }

    public List<SpokenLanguage> getSpoken_languages() { return spoken_languages; }

    public void setSpoken_languages(List<SpokenLanguage> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getTagline() { return tagline; }

    public void setTagline(String tagline) { this.tagline = tagline; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public float getVote_average() { return vote_average; }

    public void setVote_average(float vote_average) { this.vote_average = vote_average; }

    public long getVote_count() { return vote_count; }

    public void setVote_count(long vote_count) { this.vote_count = vote_count; }

    public long getRevenue() { return revenue; }

    public void setRevenue(long revenue) { this.revenue = revenue; }

    public boolean isAdult() { return adult; }

    public void setAdult(boolean adult) { this.adult = adult; }

    public String getBackdrop_path() { return backdrop_path; }

    public void setBackdrop_path(String backdrop_path) { this.backdrop_path = backdrop_path; }

    public List<Genre> getGenres() { return genres; }

    public void setGenres(List<Genre> genres) { this.genres = genres; }

    public String getHomepage() { return homepage; }

    public void setHomepage(String homepage) { this.homepage = homepage; }

    public String getImdb_id() { return imdb_id; }

    public void setImdb_id(String imdb_id) { this.imdb_id = imdb_id; }

    public String getOriginal_language() { return original_language; }

    public void setOriginal_language(String original_language) { this.original_language = original_language; }

    public String getPoster_path() { return poster_path; }

    public void setPoster_path(String poster_path) { this.poster_path = poster_path; }

    public List<ProductionCountry> getProduction_countries() { return production_countries; }

    public void setProduction_countries(List<ProductionCountry> production_countries) {
        this.production_countries = production_countries;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public boolean isVideo() { return video; }

    public void setVideo(boolean video) { this.video = video; }

    public boolean isSuccess() { return success; }

    public void setSuccess(boolean success) { this.success = success; }
}

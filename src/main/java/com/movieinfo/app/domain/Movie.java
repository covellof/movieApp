package com.movieinfo.app.domain;

import com.movieinfo.app.domain.response.MovieResponse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
public class Movie {

    @Id
    @Field("_id")
    private String id;

    private Integer movieDBId;
    private boolean adult;
    private String backdrop_path;
    private MovieCollection belongs_to_collection;
    private long budget;
    private List<Genre> genres;
    private String homepage;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private long popularity;
    private String poster_path;
    private List<ProductionCompany> production_companies;
    private List<ProductionCountry> production_countries;
    private String release_date;
    private int runtime;
    private List<SpokenLanguage> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private float vote_average;
    private long vote_count;
    private long revenue;

    public Movie() {}

    public Integer getMovieDBId() { return movieDBId; }

    public void setMovieDBId(Integer movieDBId) { this.movieDBId = movieDBId; }

    public boolean isAdult() { return adult; }

    public void setAdult(boolean adult) { this.adult = adult; }

    public String getBackdrop_path() { return backdrop_path; }

    public void setBackdrop_path(String backdrop_path) { this.backdrop_path = backdrop_path; }

    public MovieCollection getBelongs_to_collection() { return belongs_to_collection; }

    public void setBelongs_to_collection(MovieCollection belongs_to_collection) { this.belongs_to_collection = belongs_to_collection; }

    public long getBudget() { return budget; }

    public void setBudget(long budget) { this.budget = budget; }

    public List<Genre> getGenres() { return genres; }

    public void setGenres(List<Genre> genres) { this.genres = genres; }

    public String getHomepage() { return homepage; }

    public void setHomepage(String homepage) { this.homepage = homepage; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getImdb_id() { return imdb_id; }

    public void setImdb_id(String imdb_id) { this.imdb_id = imdb_id; }

    public String getOriginal_language() { return original_language; }

    public void setOriginal_language(String original_title) { this.original_language = original_language; }

    public String getOriginal_title() { return original_title; }

    public void setOriginal_title(String original_title) { this.original_title = original_title; }

    public String getOverview() { return overview; }

    public void setOverview(String overview) { this.overview = overview; }

    public long getPopularity() { return popularity; }

    public void setPopularity(long popularity) { this.popularity = popularity; }

    public String getPoster_path() { return poster_path; }

    public void setPoster_path(String poster_path) { this.poster_path = poster_path; }

    public List<ProductionCompany> getProduction_companies() { return production_companies; }

    public void setProduction_companies(List<ProductionCompany> production_companies) {
        this.production_companies = production_companies;
    }

    public List<ProductionCountry> getProduction_countries() { return production_countries; }

    public void setProduction_countries(List<ProductionCountry> production_countries) {
        this.production_countries = production_countries;
    }

    public String getRelease_date() { return release_date; }

    public void setRelease_date(String release_date) { this.release_date = release_date; }

    public int getRuntime() { return runtime; }

    public void setRuntime(int runtime) { this.runtime = runtime; }

    public List<SpokenLanguage> getSpoken_languages() { return spoken_languages; }

    public void setSpoken_languages(List<SpokenLanguage> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getTagline() { return tagline; }

    public void setTagline(String tagline) { this.tagline = tagline; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public boolean isVideo() { return video; }

    public void setVideo(boolean video) { this.video = video; }

    public float getVote_average() { return vote_average; }

    public void setVote_average(float vote_average) { this.vote_average = vote_average; }

    public long getVote_count() { return vote_count; }

    public void setVote_count(long vote_count) { this.vote_count = vote_count; }

    public long getRevenue() { return revenue; }

    public void setRevenue(long revenue) { this.revenue = revenue; }

    public static Movie mapToDocument(MovieResponse response) {
        Movie document = new Movie();
        document.setMovieDBId(response.getId());
        document.setBudget(response.getBudget());
        document.setBelongs_to_collection(response.getBelongs_to_collection());
        document.setOriginal_title(response.getOriginal_title());
        document.setPopularity(response.getPopularity());
        document.setOverview(response.getOverview());
        document.setProduction_companies(response.getProduction_companies());
        document.setRelease_date(response.getRelease_date());
        document.setRuntime(response.getRuntime());
        document.setSpoken_languages(response.getSpoken_languages());
        document.setTagline(response.getTagline());
        document.setTitle(response.getTitle());
        document.setVote_average(response.getVote_average());
        document.setVote_count(response.getVote_count());
        document.setGenres(response.getGenres());
        document.setHomepage(response.getHomepage());
        document.setImdb_id(response.getImdb_id());
        document.setPoster_path(response.getPoster_path());
        document.setProduction_countries(response.getProduction_countries());
        document.setStatus(response.getStatus());
        document.setVideo(response.isVideo());
        document.setAdult(response.isAdult());
        document.setBackdrop_path(response.getBackdrop_path());
        return document;
    }

    public static MovieResponse toResponse(Movie document) {
        MovieResponse response = new MovieResponse();
        response.setId(document.getMovieDBId());
        response.setBudget(document.getBudget());
        response.setBelongs_to_collection(document.getBelongs_to_collection());
        response.setOriginal_title(document.getOriginal_title());
        response.setPopularity(document.getPopularity());
        response.setOverview(document.getOverview());
        response.setProduction_companies(document.getProduction_companies());
        response.setRelease_date(document.getRelease_date());
        response.setRuntime(document.getRuntime());
        response.setSpoken_languages(document.getSpoken_languages());
        response.setTagline(document.getTagline());
        response.setTitle(document.getTitle());
        response.setVote_average(document.getVote_average());
        response.setVote_count(document.getVote_count());
        response.setGenres(document.getGenres());
        response.setHomepage(document.getHomepage());
        response.setImdb_id(document.getImdb_id());
        response.setPoster_path(document.getPoster_path());
        response.setProduction_countries(document.getProduction_countries());
        response.setStatus(document.getStatus());
        response.setVideo(document.isVideo());
        response.setAdult(document.isAdult());
        response.setBackdrop_path(document.getBackdrop_path());
        return response;
    }
}

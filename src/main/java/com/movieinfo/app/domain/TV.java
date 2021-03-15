package com.movieinfo.app.domain;

import com.movieinfo.app.domain.response.TVResponse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class TV {
    @Id
    private String id;

    private Integer tvDBId;
    private String backdrop_path;
    private List<Creator> created_by;
    private List<Integer> episode_run_time;
    private String first_air_date;
    private List<Genre> genres;
    private String homepage;
    private boolean in_production;
    private List<String> languages;
    private String last_air_date;
    private Episode last_episode_to_air;
    private String name;
    private Episode next_episode_to_air;
    private List<Network> networks;
    private int number_of_episodes;
    private int number_of_seasons;
    private List<ProductionCountry> origin_countries;
    private String original_language;
    private String original_name;
    private String overview;
    private long popularity;
    private String poster_path;
    private List<ProductionCompany> production_companies;
    private List<ProductionCountry> production_countries;
    private List<Season> seasons;
    private List<SpokenLanguage> spoken_languages;
    private String status;
    private String tagline;
    private String type;
    private float vote_average;
    private int vote_count;

    public TV() {}

    public Integer getTvDBId() { return tvDBId; }

    public void setTvDBId(Integer tvDBId) { this.tvDBId = tvDBId; }

    public String getBackdrop_path() { return backdrop_path; }

    public void setBackdrop_path(String backdrop_path) { this.backdrop_path = backdrop_path; }

    public List<Creator> getCreated_by() { return created_by; }

    public void setCreated_by(List<Creator> created_by) { this.created_by = created_by; }

    public List<Integer> getEpisode_run_time() { return episode_run_time; }

    public void setEpisode_run_time(List<Integer> episode_run_time) { this.episode_run_time = episode_run_time; }

    public String getFirst_air_date() { return first_air_date; }

    public void setFirst_air_date(String first_air_date) { this.first_air_date = first_air_date; }

    public List<Genre> getGenres() { return genres; }

    public void setGenres(List<Genre> genres) { this.genres = genres; }

    public String getHomepage() { return homepage; }

    public void setHomepage(String homepage) { this.homepage = homepage; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public boolean isIn_production() { return in_production; }

    public void setIn_production(boolean in_production) { this.in_production = in_production; }

    public List<String> getLanguages() { return languages; }

    public void setLanguages(List<String> languages) { this.languages = languages; }

    public String getLast_air_date() { return last_air_date; }

    public void setLast_air_date(String last_air_date) { this.last_air_date = last_air_date; }

    public Episode getLast_episode_to_air() { return last_episode_to_air; }

    public void setLast_episode_to_air(Episode last_episode_to_air) { this.last_episode_to_air = last_episode_to_air; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Episode getNext_episode_to_air() { return next_episode_to_air; }

    public void setNext_episode_to_air(Episode next_episode_to_air) { this.next_episode_to_air = next_episode_to_air; }

    public List<Network> getNetworks() { return networks; }

    public void setNetworks(List<Network> networks) { this.networks = networks; }

    public int getNumber_of_episodes() { return number_of_episodes; }

    public void setNumber_of_episodes(int number_of_episodes) { this.number_of_episodes = number_of_episodes; }

    public int getNumber_of_seasons() { return number_of_seasons; }

    public void setNumber_of_seasons(int number_of_seasons) { this.number_of_seasons = number_of_seasons; }

    public List<ProductionCountry> getOrigin_countries() { return origin_countries; }

    public void setOrigin_countries(List<ProductionCountry> origin_countries) { this.origin_countries = origin_countries; }

    public String getOriginal_language() { return original_language; }

    public void setOriginal_language(String original_language) { this.original_language = original_language; }

    public String getOriginal_name() { return original_name; }

    public void setOriginal_name(String original_name) { this.original_name = original_name; }

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

    public List<Season> getSeasons() { return seasons; }

    public void setSeasons(List<Season> seasons) { this.seasons = seasons; }

    public List<SpokenLanguage> getSpoken_languages() { return spoken_languages; }

    public void setSpoken_languages(List<SpokenLanguage> spoken_languages) { this.spoken_languages = spoken_languages; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getTagline() { return tagline; }

    public void setTagline(String tagline) { this.tagline = tagline; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public float getVote_average() { return vote_average; }

    public void setVote_average(float vote_average) { this.vote_average = vote_average; }

    public int getVote_count() { return vote_count; }

    public void setVote_count(int vote_count) { this.vote_count = vote_count; }

    public static TV mapToDocument(TVResponse response) {
        TV document = new TV();
        document.setTvDBId(response.getId());
        document.setLanguages(response.getLanguages());
        document.setLast_episode_to_air(response.getLast_episode_to_air());
        document.setNetworks(response.getNetworks());
        document.setNumber_of_episodes(response.getNumber_of_episodes());
        document.setSeasons(response.getSeasons());
        document.setNumber_of_seasons(response.getNumber_of_seasons());
        document.setOrigin_countries(response.getOrigin_countries());
        document.setOriginal_language(response.getOriginal_language());
        document.setType(response.getType());
        document.setOriginal_name(response.getOriginal_name());
        document.setPopularity(response.getPopularity());
        document.setOverview(response.getOverview());
        document.setProduction_companies(response.getProduction_companies());
        document.setFirst_air_date(response.getFirst_air_date());
        document.setEpisode_run_time(response.getEpisode_run_time());
        document.setSpoken_languages(response.getSpoken_languages());
        document.setTagline(response.getTagline());
        document.setName(response.getName());
        document.setVote_average(response.getVote_average());
        document.setVote_count(response.getVote_count());
        document.setGenres(response.getGenres());
        document.setHomepage(response.getHomepage());
        document.setCreated_by(response.getCreated_by());
        document.setPoster_path(response.getPoster_path());
        document.setProduction_countries(response.getProduction_countries());
        document.setStatus(response.getStatus());
        document.setIn_production(response.isIn_production());
        document.setNext_episode_to_air(response.getNext_episode_to_air());
        document.setLast_air_date(response.getLast_air_date());
        document.setBackdrop_path(response.getBackdrop_path());
        return document;
    }

    public static TVResponse mapToResponse(TV document) {
        TVResponse response= new TVResponse();
        response.setId(document.getTvDBId());
        response.setLanguages(document.getLanguages());
        response.setLast_episode_to_air(document.getLast_episode_to_air());
        response.setNetworks(document.getNetworks());
        response.setNumber_of_episodes(document.getNumber_of_episodes());
        response.setSeasons(document.getSeasons());
        response.setNumber_of_seasons(document.getNumber_of_seasons());
        response.setOrigin_countries(document.getOrigin_countries());
        response.setOriginal_language(document.getOriginal_language());
        response.setType(document.getType());
        response.setOriginal_name(document.getOriginal_name());
        response.setPopularity(document.getPopularity());
        response.setOverview(document.getOverview());
        response.setProduction_companies(document.getProduction_companies());
        response.setFirst_air_date(document.getFirst_air_date());
        response.setEpisode_run_time(document.getEpisode_run_time());
        response.setSpoken_languages(document.getSpoken_languages());
        response.setTagline(document.getTagline());
        response.setName(document.getName());
        response.setVote_average(document.getVote_average());
        response.setVote_count(document.getVote_count());
        response.setGenres(document.getGenres());
        response.setHomepage(document.getHomepage());
        response.setCreated_by(document.getCreated_by());
        response.setPoster_path(document.getPoster_path());
        response.setProduction_countries(document.getProduction_countries());
        response.setStatus(document.getStatus());
        response.setIn_production(document.isIn_production());
        response.setNext_episode_to_air(document.getNext_episode_to_air());
        response.setLast_air_date(document.getLast_air_date());
        response.setBackdrop_path(document.getBackdrop_path());
        return response;
    }
}

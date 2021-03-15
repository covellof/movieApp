package com.movieinfo.app.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Season {

    @Id
    private String id;

    private String air_date;
    private int episode_count;
    private String name;
    private String overview;
    private String poster_path;
    private int season_number;

    public Season() {}

    public String getAir_date() { return air_date; }

    public void setAir_date(String air_date) { this.air_date = air_date; }

    public int getEpisode_count() { return episode_count; }

    public void setEpisode_count(int episode_count) { this.episode_count = episode_count; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getOverview() { return overview; }

    public void setOverview(String overview) { this.overview = overview; }

    public String getPoster_path() { return poster_path; }

    public void setPoster_path(String poster_path) { this.poster_path = poster_path; }

    public int getSeason_number() { return season_number; }

    public void setSeason_number(int season_number) { this.season_number = season_number; }
}

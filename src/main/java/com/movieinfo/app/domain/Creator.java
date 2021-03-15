package com.movieinfo.app.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Creator {

    @Id
    private Integer id;
    private String credit_id;
    private String name;
    private int gender;
    private String profile_path;

    public Creator(Integer id, String credit_id, String name, int gender, String profile_path) {
        this.id = id;
        this.credit_id = credit_id;
        this.name = name;
        this.gender = gender;
        this.profile_path = profile_path;
    }

    public Creator() {}

    public int getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getCredit_id() { return credit_id; }

    public void setCredit_id(String credit_id) { this.credit_id = credit_id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getGender() { return gender; }

    public void setGender(int gender) { this.gender = gender; }

    public String getProfile_path() { return profile_path; }

    public void setProfile_path(String profile_path) { this.profile_path = profile_path; }
}

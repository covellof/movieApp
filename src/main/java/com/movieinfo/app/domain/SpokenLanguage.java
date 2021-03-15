package com.movieinfo.app.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SpokenLanguage {

    @Id
    private String iso_639_1;

    private String english_name;
    private String name;

    public SpokenLanguage(String english_name, String iso_639_1, String name) {
        this.english_name = english_name;
        this.iso_639_1 = iso_639_1;
        this.name = name;
    }

    public SpokenLanguage() {}

    public String getEnglish_name() { return english_name; }

    public void setEnglish_name(String english_name) { this.english_name = english_name; }

    public String getIso_639_1() { return iso_639_1; }

    public void setIso_639_1(String iso_639_1) { this.iso_639_1 = iso_639_1; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}

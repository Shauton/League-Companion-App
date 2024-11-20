package com.example.leaguecompanionapp;

public class Champion {
    String name;
    String description;
    int imageId;


    public Champion(String name, String description, int imageId) {
        this.name = name;
        this.description = description;
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}

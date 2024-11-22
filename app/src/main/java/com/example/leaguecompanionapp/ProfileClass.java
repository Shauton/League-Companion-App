package com.example.leaguecompanionapp;

import android.graphics.Bitmap;

public class ProfileClass {
    private String username, password;
    private Bitmap image;

    public ProfileClass(String username, String password, Bitmap image) {
        this.username = username;
        this.password = password;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}

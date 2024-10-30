package com.example.leaguecompanionapp.ui.dashboard;

public class ViewModel {

    private String name, title;

    public ViewModel(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}

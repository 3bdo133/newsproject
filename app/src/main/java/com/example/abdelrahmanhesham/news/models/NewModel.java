package com.example.abdelrahmanhesham.news.models;

/**
 * Created by Abdelrahman Hesham on 3/8/2018.
 */

public class NewModel {

    private String title;
    private String description;

    public NewModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

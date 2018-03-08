package com.example.abdelrahmanhesham.news;

/**
 * Created by Abdelrahman Hesham on 3/8/2018.
 */

public class New {

    private String title;
    private String description;

    public New(String title, String description) {
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

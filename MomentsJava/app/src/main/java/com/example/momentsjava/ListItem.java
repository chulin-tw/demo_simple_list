package com.example.momentsjava;

public class ListItem {
    String title;

    String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ListItem(String title, String description) {
        this.title = title;
        this.description = description;
    }
}

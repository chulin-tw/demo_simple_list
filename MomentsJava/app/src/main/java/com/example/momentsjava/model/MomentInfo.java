package com.example.momentsjava.model;

import java.util.List;

public class MomentInfo {
    private String text;
    private List<String> picture;

    public MomentInfo(String text, List<String> picture) {
        this.text = text;
        this.picture = picture;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }
}

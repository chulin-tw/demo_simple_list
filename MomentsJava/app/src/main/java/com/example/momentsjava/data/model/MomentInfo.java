package com.example.momentsjava.data.model;

import androidx.annotation.NonNull;

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

    @NonNull
    @Override
    public String toString() {
        return "MomentInfo{" +
                "text='" + text + '\'' +
                ", picture=" + picture +
                '}';
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }
}

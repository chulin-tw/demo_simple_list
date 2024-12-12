package com.example.momentsjava.data.model;

import androidx.annotation.NonNull;

public class ListItem {
    private UserInfo userInfo;
    private MomentInfo momentInfo;

    public ListItem(UserInfo userInfo, MomentInfo momentInfo) {
        this.userInfo = userInfo;
        this.momentInfo = momentInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public MomentInfo getMomentInfo() {
        return momentInfo;
    }

    public void setMomentInfo(MomentInfo momentInfo) {
        this.momentInfo = momentInfo;
    }

    @NonNull
    @Override
    public String toString() {
        return "ListItem{" +
                "userInfo=" + userInfo +
                ", momentInfo=" + momentInfo +
                '}';
    }
}

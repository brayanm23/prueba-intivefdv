package com.example.intive_fdv.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListUserResponse {

    @Expose
    @SerializedName("results")
    private List<User> users;

    @Expose
    @SerializedName("info")
    private Information information;

    public ListUserResponse() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }
}

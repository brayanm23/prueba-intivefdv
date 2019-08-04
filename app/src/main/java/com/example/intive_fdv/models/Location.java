package com.example.intive_fdv.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Location implements Serializable {

    /*@Expose
    @SerializedName("street")
    private String street;

    @Expose
    @SerializedName("city")
    private String city;

    @Expose
    @SerializedName("state")
    private String state;

    @Expose
    @SerializedName("postcode")
    private Integer postcode;*/

    @Expose
    @SerializedName("coordinates")
    private Coordinates coordinates;

    public Location() {
    }

    /*public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }*/

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}

package com.example.intive_fdv.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    public static String tagUser = "user";

    @Expose
    @SerializedName("id")
    private Id id;

    @Expose
    @SerializedName("name")
    private Name name;

    @Expose
    @SerializedName("picture")
    private Picture picture;

    @Expose
    @SerializedName("gender")
    private String gender;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("phone")
    private String phone;

    @Expose
    @SerializedName("cell")
    private String cell;

    @Expose
    @SerializedName("nat")
    private String nat;

    //"location": {},
    //"login": {},
    //"dob": {},
    //"registered": {},

    public User() {
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }
}

package com.example.intive_fdv.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Id implements Serializable {

    @Expose
    @SerializedName("CPR")
    private String CPR;

    @Expose
    @SerializedName("value")
    private String value;


    public Id() {
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

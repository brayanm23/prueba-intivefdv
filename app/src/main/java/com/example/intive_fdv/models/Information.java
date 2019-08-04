package com.example.intive_fdv.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Information implements Serializable {

    @Expose
    @SerializedName("seed")
    private String seed;

    @Expose
    @SerializedName("results")
    private Integer results;

    @Expose
    @SerializedName("page")
    private Integer page;

    @Expose
    @SerializedName("version")
    private String version;

    public Information() {
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

package com.geektech.boredapp.model;

import com.google.gson.annotations.SerializedName;

public class BoredAction {
    @SerializedName("key")
    private String key;

    @SerializedName("activity")
    private String activity;

    @SerializedName("accessibility")
    private Float accessibility;

    @SerializedName("type")
    private String type;

    @SerializedName("participants")
    private Integer participants;

    @SerializedName("price")
    private Float price;

    @SerializedName("link")
    private String link;

    public BoredAction(String key, String activity, Float accessibility, String type, Integer participants, Float price, String link) {
        this.key = key;
        this.activity = activity;
        this.accessibility = accessibility;
        this.type = type;
        this.participants = participants;
        this.price = price;
        this.link = link;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Float getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Float accessibility) {
        this.accessibility = accessibility;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
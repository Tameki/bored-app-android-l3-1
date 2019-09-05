package com.geektech.boredapp.model;

import com.google.gson.annotations.SerializedName;

public enum EActionType {
    @SerializedName("education") EDUCATION,
    @SerializedName("recreational") RECREATIONAL,
    @SerializedName("social") SOCIAL,
    @SerializedName("diy") DIY,
    @SerializedName("charity") CHARITY,
    @SerializedName("cooking") COOKING,
    @SerializedName("relaxation") RELAXATION,
    @SerializedName("music") MUSIC,
    @SerializedName("busywork") BUSYWORK
}
package com.jongchan.ctest.model;

import com.google.gson.annotations.SerializedName;

public class PhotoItem {
    @SerializedName("date_taken")
    public String dateTaken;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;
    @SerializedName("width")
    public String width;
    @SerializedName("height")
    public String height;
}

package com.jongchan.ctest.entity;

import com.google.gson.annotations.SerializedName;
import com.jongchan.ctest.model.PhotoItem;

import java.util.List;

public class PhotoResponse {
    @SerializedName("stat")
    public String stat;
    @SerializedName("page")
    public int page;
    @SerializedName("total_page")
    public int totalPage;
    @SerializedName("photos")
    public List<PhotoItem> photos;
}

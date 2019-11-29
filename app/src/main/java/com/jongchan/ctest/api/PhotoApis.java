package com.jongchan.ctest.api;

import com.jongchan.ctest.entity.PhotoResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PhotoApis {

    @GET("/images")
    Observable<PhotoResponse> getPhotoList();
}

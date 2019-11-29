package com.jongchan.ctest.feature;

import android.annotation.SuppressLint;
import android.util.Log;

import com.jongchan.ctest.api.PhotoApis;
import com.jongchan.ctest.entity.PhotoResponse;
import com.jongchan.ctest.network.AppRequestAPI;

import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class PhotoRepository {
    private Observable<PhotoResponse> getPhotoList() {
        return AppRequestAPI.getInstance().getRetrofit().create(PhotoApis.class).getPhotoList();
    }

    @SuppressLint("CheckResult")
    void requestPhotoList(PhotoListViewModel.OnPhotoFetchedListener listener) {
        getPhotoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        photoResponse -> {
                            listener.fetchedPhotoItems(photoResponse.photos);
                        },
                        error -> {
                            Log.d("requestPhotoList", Objects.requireNonNull(error.getMessage()));
                        }
                );
    }
}

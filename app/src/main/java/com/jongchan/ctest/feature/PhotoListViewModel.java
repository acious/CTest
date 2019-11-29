package com.jongchan.ctest.feature;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.jongchan.ctest.feature.photolist.OnPhotoItemClickListener;
import com.jongchan.ctest.model.PhotoItem;
import com.jongchan.ctest.mvvm.SingleLiveEvent;

import java.util.ArrayList;
import java.util.List;

public class PhotoListViewModel extends ViewModel implements OnPhotoItemClickListener {

    private PhotoRepository mRepository = new PhotoRepository();

    private SingleLiveEvent<Integer> mMoveViewer = new SingleLiveEvent<>();
    private SingleLiveEvent<PhotoItem> mRefreshPhotoItems = new SingleLiveEvent<>();
    private ObservableField<Integer> mEnteredPosition = new ObservableField<>();

    private List<PhotoItem> mItems = new ArrayList<>();

    public void loadPhotoList() {
        mRepository.requestPhotoList(items -> {
            mItems.clear();
            mItems.addAll(items);
            mRefreshPhotoItems.call();
        });
    }

    public SingleLiveEvent<Integer> navigateToViewerWithPosition() {
        return mMoveViewer;
    }

    public SingleLiveEvent<PhotoItem> refreshPhotoItems() {
        return mRefreshPhotoItems;
    }

    public ObservableField<Integer> getEnteredPosition() {
        return mEnteredPosition;
    }

    public void setEnteredPosition(int enteredPosition) {
        mEnteredPosition.set(enteredPosition);
    }

    public List<PhotoItem> getItems() {
        return mItems;
    }

    @Override
    public void onPhotoItemClick(int position) {
        mMoveViewer.setValue(position);
    }

    interface OnPhotoFetchedListener {
        void fetchedPhotoItems(List<PhotoItem> items);
    }
}

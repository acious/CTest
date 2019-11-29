package com.jongchan.ctest.feature.photoviewer;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jongchan.ctest.databinding.PhotoViewerPageFragBinding;
import com.jongchan.ctest.feature.PhotoListViewModel;

public class PhotoViewerPageFragment extends Fragment {

    private static final String BUNDLE_PHOTO_ITEM_POSITION = "BUNDLE_PHOTO_ITEM_POSITION";

    private PhotoViewerPageFragBinding mBinding;
    private PhotoListViewModel mViewModel;
    private int mItemPosition;

    public PhotoViewerPageFragment() {
        // Required empty public constructor
    }

    public static PhotoViewerPageFragment newInstance(int position) {
        PhotoViewerPageFragment fragment = new PhotoViewerPageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_PHOTO_ITEM_POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mItemPosition = getArguments().getInt(BUNDLE_PHOTO_ITEM_POSITION, 0);
        }

        mViewModel = ViewModelProviders.of(getActivity()).get(PhotoListViewModel.class);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = PhotoViewerPageFragBinding.inflate(LayoutInflater.from(getContext()));
        mBinding.setPhotoItem(mViewModel.getItems().get(mItemPosition));
        return mBinding.getRoot();
    }
}

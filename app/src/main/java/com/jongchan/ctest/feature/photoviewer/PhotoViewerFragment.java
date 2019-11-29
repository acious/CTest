package com.jongchan.ctest.feature.photoviewer;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jongchan.ctest.R;
import com.jongchan.ctest.databinding.PhotoListFragBinding;
import com.jongchan.ctest.databinding.PhotoViewerFragBinding;
import com.jongchan.ctest.feature.PhotoListViewModel;

public class PhotoViewerFragment extends Fragment {

    private PhotoListViewModel mViewModel;
    private PhotoViewerFragBinding mBinding;
    private PhotoViewerPagerAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = ViewModelProviders.of(getActivity()).get(PhotoListViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = PhotoViewerFragBinding.inflate(LayoutInflater.from(getContext()));
        mBinding.setViewModel(mViewModel);

        initPager();
        return mBinding.getRoot();
    }

    private void initPager() {
        mAdapter = new PhotoViewerPagerAdapter(getActivity(), mViewModel);
        mBinding.photoViewerPager.setAdapter(mAdapter);
    }
}

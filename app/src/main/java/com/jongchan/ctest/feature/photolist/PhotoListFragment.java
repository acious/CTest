package com.jongchan.ctest.feature.photolist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jongchan.ctest.R;
import com.jongchan.ctest.databinding.PhotoListFragBinding;
import com.jongchan.ctest.feature.PhotoListViewModel;

public class PhotoListFragment extends Fragment {

    private PhotoListViewModel mViewModel;
    private PhotoListFragBinding mBinding;
    private PhotoListAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = ViewModelProviders.of(getActivity()).get(PhotoListViewModel.class);
        observePhotoListVM();
        mViewModel.loadPhotoList();
    }

    private void observePhotoListVM() {
        mViewModel.navigateToViewerWithPosition().observe(this, selectedPosition -> {
            navigateToPhotoViewer(selectedPosition);
        });

        mViewModel.refreshPhotoItems().observe(this, aVoid -> {
            mAdapter.refresh();
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = PhotoListFragBinding.inflate(LayoutInflater.from(getContext()));
        mBinding.setViewModel(mViewModel);
        initList();

        return mBinding.getRoot();
    }

    private void initList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new PhotoListAdapter();
        mAdapter.setViewModel(mViewModel);
        mBinding.photoListContentsList.setLayoutManager(layoutManager);
        mBinding.photoListContentsList.setAdapter(mAdapter);
    }

    private void navigateToPhotoViewer(int selectedPosition) {
        mViewModel.setEnteredPosition(selectedPosition);
        Navigation.findNavController(mBinding.getRoot()).navigate(R.id.action_photoListFragment_to_photoViewerFragment);
    }
}

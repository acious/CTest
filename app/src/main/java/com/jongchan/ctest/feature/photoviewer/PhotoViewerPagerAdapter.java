package com.jongchan.ctest.feature.photoviewer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jongchan.ctest.feature.PhotoListViewModel;

class PhotoViewerPagerAdapter extends FragmentStateAdapter {
    private final PhotoListViewModel mViewModel;

    public PhotoViewerPagerAdapter(@NonNull FragmentActivity fragmentActivity, PhotoListViewModel viewModel) {
        super(fragmentActivity);
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return PhotoViewerPageFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getItems().size();
    }
}

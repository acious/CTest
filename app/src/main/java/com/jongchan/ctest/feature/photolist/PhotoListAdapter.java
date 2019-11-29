package com.jongchan.ctest.feature.photolist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jongchan.ctest.databinding.PhotoListItemBinding;
import com.jongchan.ctest.feature.PhotoListViewModel;

class PhotoListAdapter extends RecyclerView.Adapter<PhotoListItemVH> {

    private PhotoListViewModel mViewModel;

    @NonNull
    @Override
    public PhotoListItemVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PhotoListItemBinding binding = PhotoListItemBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhotoListItemVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoListItemVH holder, int position) {
        holder.bind(position, mViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getItems().size();
    }

    public void setViewModel(PhotoListViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    public void refresh() {
        notifyDataSetChanged();
    }
}

package com.jongchan.ctest.feature.photolist;

import androidx.recyclerview.widget.RecyclerView;

import com.jongchan.ctest.databinding.PhotoListItemBinding;
import com.jongchan.ctest.feature.PhotoListViewModel;
import com.jongchan.ctest.model.PhotoItem;

class PhotoListItemVH extends RecyclerView.ViewHolder {
    private PhotoListItemBinding mBinding;
    public PhotoListItemVH(PhotoListItemBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(int itemPosition, PhotoListViewModel viewModel) {
        mBinding.setItemPosition(itemPosition);
        mBinding.setPhotoItem(viewModel.getItems().get(itemPosition));
        mBinding.setListener(viewModel);
    }
}

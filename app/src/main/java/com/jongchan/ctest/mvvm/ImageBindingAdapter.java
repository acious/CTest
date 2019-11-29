package com.jongchan.ctest.mvvm;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ImageBindingAdapter {
    @BindingAdapter(value = {"glideUrl", "glidePlaceholder"}, requireAll = false)
    public static void setGlide(ImageView imageView, String url, Drawable placeholder) {

        Glide.with(imageView.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .fitCenter()
                .centerCrop()
                .placeholder(placeholder)
                .into(imageView);
    }
}

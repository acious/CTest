package com.jongchan.ctest.feature;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.jongchan.ctest.model.PhotoItem;
import com.jongchan.ctest.util.StringUtil;

public class PhotoBindingAdapter {
    @BindingAdapter("currentItem")
    public static void setCurrentItem(ViewPager2 viewPager, int currentItemIndex) {
        viewPager.setCurrentItem(currentItemIndex, false);
    }


    @BindingAdapter("resolution")
    public static void setResolution(TextView textView, PhotoItem item) {
        String width = item.width;
        String height = item.height;

        if (StringUtil.isNullOrEmpty(width) || StringUtil.isNullOrEmpty(height)) {
            return;
        }

        textView.setText(String.format("%s x %s", width, height));
    }
}

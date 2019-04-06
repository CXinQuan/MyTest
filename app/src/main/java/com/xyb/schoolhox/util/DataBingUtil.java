package com.xyb.schoolhox.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.xyb.schoolhox.R;
import com.xyb.schoolhox.global.MyApplication;

/**
 * Created by 陈鑫权  on 2019/3/20.
 */

public class DataBingUtil {

    @BindingAdapter({"android:bitmapUrl", "android:corn"})
    public static void setBitmapUrl(ImageView imageView, String url, int corn) {
        //  int i = Integer.parseInt(corn);
        RoundedCorners roundedCorners = new RoundedCorners(DensityUtils.dp2px(MyApplication.mCtx, corn));
        //通过RequestOptions扩展功能
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners)
                .centerCrop();


        Glide.with(MyApplication.mCtx)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    @BindingAdapter({"android:isShowBotton"})
    public static void setItemFromShowButton(ImageView imageView, boolean isShowBotton) {
        if (isShowBotton) {
            imageView.setImageResource(R.drawable.up);
        }else {
            imageView.setImageResource(R.drawable.enter);
        }
    }


}

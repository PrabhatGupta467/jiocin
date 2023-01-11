package com.example.jiocin;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;
import java.util.Objects;

public class CarouselViewPagerAdapter extends PagerAdapter {

    //context object
    private Context context;

    //Array of images
    List<Media> images;

    //Layout inflater
    LayoutInflater layoutInflater;


    //viewpager constructor
    public CarouselViewPagerAdapter(Context context, List<Media> images) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //inflating the item_carousel_view.xml
        View itemView = layoutInflater.inflate(R.layout.item_carousel_view, container, false);

        //image reference
        ImageView imageView = itemView.findViewById(R.id.carouselImageView);

        //setting the image
        Media media = images.get(position);
//        new DownloadImageInBackground(imageView, media.mediaUrl).execute();

        downloadImage(imageView, media.mediaUrl, itemView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //adding the view
        Objects.requireNonNull(container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
    private void downloadImage(ImageView imageView, String imageUrl, View itemView) {
        try {
            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
            circularProgressDrawable.setStrokeWidth(5f);
            circularProgressDrawable.setCenterRadius(30f);
            circularProgressDrawable.start();
            Glide.with(context)
                    .load(imageUrl.trim())
                    .placeholder(circularProgressDrawable)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            Log.e("failed",e.getMessage());
                            return false;
                        }
                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

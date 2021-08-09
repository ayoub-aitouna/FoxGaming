package com.Portfolio.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.Portfolio.Modules.StoriesContent;
import com.Portfolio.foxgaming.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StoriesViewPagerAdapter extends PagerAdapter {
    Context mContext;
    List<StoriesContent> mListScreen;

    public StoriesViewPagerAdapter(Context mContext, List<StoriesContent> mListScreen) {
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View StoriesView = inflater.inflate(R.layout.view_stories_item_layout, container, false);
        ImageView StorieContainer = StoriesView.findViewById(R.id.ContentMedia);
        Picasso.with(mContext).load(mListScreen.get(position).getContentImgUri()).into(StorieContainer);
        container.addView(StoriesView);
        return StoriesView;
    }

    @Override
    public int getCount() {

        return mListScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

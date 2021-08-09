package com.Portfolio.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.Portfolio.Interfaces.StoriesOnComplete;
import com.Portfolio.Modules.Stories;
import com.Portfolio.Modules.StoriesContent;
import com.Portfolio.Modules.Tabs;
import com.Portfolio.foxgaming.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jp.shts.android.storiesprogressview.StoriesProgressView;

public class StoriesViewAdapter extends RecyclerView.Adapter<StoriesViewAdapter.mHolder> {
    List<Stories> StoriesData;
    Context mContext;
    private Boolean SkipByClick = false;
    private int position = 0;
    private StoriesOnComplete storiesOnComplete;

    public StoriesViewAdapter(List<Stories> storiesData, StoriesOnComplete storiesOnComplete) {
        StoriesData = storiesData;
        this.storiesOnComplete = storiesOnComplete;
    }

    @NonNull
    @Override
    public mHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new mHolder(
                LayoutInflater.from(
                        parent.getContext()).inflate(
                        R.layout.view_stories_container_layout, parent, false
                )
        );

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull mHolder holder, int position) {
        holder.setIsRecyclable(false);

        // setup viewpager
        List<StoriesContent> ItemData = StoriesData.get(position).getContent();

        StoriesViewPagerAdapter storiesViewAdapter = new StoriesViewPagerAdapter(mContext, ItemData);
        holder.screenPager.setAdapter(storiesViewAdapter);
        holder.storiesProgressView.setStoriesCount(ItemData.size()); // <- set stories
        holder.storiesProgressView.setStoryDuration(3200L); // <- set a story duration

        holder.storiesProgressView.setStoriesListener(new StoriesProgressView.StoriesListener() {
            @Override
            public void onNext() {
                if (!SkipByClick) {
                    NEXT(holder);

                }
                SkipByClick = false;

            }

            @Override
            public void onPrev() {
                // Call when finished revserse animation.
                if (!SkipByClick) {
                    PERV(holder);
                }
                SkipByClick = false;

            }

            @Override
            public void onComplete() {
                storiesOnComplete.Complete(position);
            }
        }); // <- set listener
        holder.storiesProgressView.startStories(); // <- start progress

        holder.left.setOnClickListener(v -> {
            SkipByClick = true;
            PERV(holder);
            holder.storiesProgressView.reverse();
        });
        holder.Right.setOnClickListener(v -> {
            SkipByClick = true;
            NEXT(holder);
            holder.storiesProgressView.skip();
        });


        holder.screenPager.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    // Start
                    holder.storiesProgressView.pause();
                    return true;

                case MotionEvent.ACTION_UP:
                    // End
                    holder.storiesProgressView.resume();
                    return true;
            }
            return false;
        });


    }

    private void NEXT(mHolder holder) {
//        position = screenPager.getCurrentItem();
        position = holder.screenPager.getCurrentItem();
        if (position <= StoriesData.size()) {
            position = position + 1;
            holder.screenPager.setCurrentItem(position);

        }

        if (position == StoriesData.size()) { // when we rech to the last screen
            // TODO : change the stories Array to the next
            storiesOnComplete.Complete(holder.getAdapterPosition());

        }
    }

    private void PERV(mHolder holder) {
        position = holder.screenPager.getCurrentItem();
        if (position > 0) {

            position = position - 1;
            holder.screenPager.setCurrentItem(position);


        }

        if (position == 0) { // when we rech to the last screen
            // TODO : change the stories Array to the next
            storiesOnComplete.PERV(holder.getAdapterPosition());

        }
    }

    private void ChangeAccountStories() {
    }

    @Override
    public int getItemCount() {
        return StoriesData.size();
    }

    static class mHolder extends RecyclerView.ViewHolder {
        private StoriesProgressView storiesProgressView;
        View left, Right;
        LinearLayout linearLayout;
        private ViewPager screenPager;


        public mHolder(@NonNull View itemView) {
            super(itemView);

            storiesProgressView = itemView.findViewById(R.id.stories);
            left = itemView.findViewById(R.id.left);
            Right = itemView.findViewById(R.id.right);
            screenPager = itemView.findViewById(R.id.PagerMedia);
            linearLayout = itemView.findViewById(R.id.linearLayout);

        }
    }

}
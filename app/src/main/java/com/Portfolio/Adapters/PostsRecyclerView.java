package com.Portfolio.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Portfolio.foxgaming.R;

import java.util.ArrayList;

public class PostsRecyclerView extends RecyclerView.Adapter<PostsRecyclerView.MyHolder> {

    private ArrayList Posts;
    private Context mContext;

    public PostsRecyclerView(ArrayList posts, Context mContext) {
        Posts = posts;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.gamer_posts_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return Posts.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

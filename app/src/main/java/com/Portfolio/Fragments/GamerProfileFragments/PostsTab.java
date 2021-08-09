package com.Portfolio.Fragments.GamerProfileFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Portfolio.Adapters.PostRecyclerview;
import com.Portfolio.Adapters.PostsRecyclerView;
import com.Portfolio.CostumeUtils.VideoPlayerRecyclerView;
import com.Portfolio.Modules.MediaObject;
import com.Portfolio.Utils.VerticalSpacingItemDecorator;
import com.Portfolio.foxgaming.R;

import java.util.ArrayList;

public class PostsTab extends Fragment {
    ArrayList<String> posts = new ArrayList<>();
    private ArrayList<MediaObject> MEDIA_OBJECTS = new ArrayList<>();
    private VideoPlayerRecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.posts_tab_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FillData();
        PostsRecyclerView adapter = new PostsRecyclerView(posts, getActivity());
        mRecyclerView = view.findViewById(R.id.Posts_RecyclerView);

        LinearLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(layoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setMediaObjects(MEDIA_OBJECTS);
        mRecyclerView.setAdapter(adapter);


    }

    private void FillData() {


        posts.add("ss");
        posts.add("ss");
        posts.add("ss");
        posts.add("ss");
        posts.add("ss");
        posts.add("ss");
        posts.add("ss");
        posts.add("ss");
        posts.add("ss");
        posts.add("ss");
        posts.add("ss");
        posts.add("ss");
        posts.add("ss");
        posts.add("ss");
        posts.add("ss");

    }
}

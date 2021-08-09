package com.Portfolio.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.Portfolio.Adapters.PostRecyclerview;
import com.Portfolio.CostumeUtils.VideoPlayerRecyclerView;
import com.Portfolio.Modules.MediaObject;
import com.Portfolio.Utils.VerticalSpacingItemDecorator;
import com.Portfolio.foxgaming.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AllgamesTab extends Fragment {
    private ArrayList<MediaObject> MEDIA_OBJECTS = new ArrayList<>();

    private VideoPlayerRecyclerView mRecyclerView;
    private View view;

    @Override
    public void onPause() {
        if (mRecyclerView != null)
            mRecyclerView.Pause();
        super.onPause();
    }

    @Override
    public void onResume() {
        if (mRecyclerView != null)
            mRecyclerView.play();
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.all_games_tab_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FillStories();

        // Lookup the recyclerview in activity layout
        mRecyclerView = view.findViewById(R.id.recycler_view);
        initRecyclerView();

    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setMediaObjects(MEDIA_OBJECTS);
        PostRecyclerview adapter = new PostRecyclerview(MEDIA_OBJECTS, initGlide());
        mRecyclerView.setAdapter(adapter);
    }

    private RequestManager initGlide() {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background);

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }


    private void FillStories() {

        MEDIA_OBJECTS.add(new MediaObject("Sending Data to a New Activity with Intent Extras",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
                "https://mmos.com/wp-content/gallery/league-of-legends/League-of-Legends-Early.jpg",
                "They Wanted To Dive BABUS - Best of LoL Streams #1441\n"));
        MEDIA_OBJECTS.add(new MediaObject("MVVM and LiveData",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
                "https://media.pocketgamer.com/artwork/na-30672-1605595336/viber_image_2020-11-17_14-40-414_jpg_1280.jpg",
                "OMG! SHIELD YOUR ENTIRE HEALTHBAR WITH SUPER SHIELD MORDEKAISER"));

        MEDIA_OBJECTS.add(new MediaObject("REST API, Retrofit2, MVVM Course SUMMARY",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
                "https://www.researchgate.net/profile/Yubo-Kou/publication/343696773/figure/fig1/AS:925549996298245@1597679723345/Screenshot-of-League-of-Legends-LoL-affords-a-variety-of-ways-for-players-to-express.png",
                "He Spent $60000 Gifting Subs - Best of LoL Streams #1442"));
    MEDIA_OBJECTS.add(new MediaObject("Sending Data to a New Activity with Intent Extras",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
                "https://mmos.com/wp-content/gallery/league-of-legends/League-of-Legends-Early.jpg",
                "They Wanted To Dive BABUS - Best of LoL Streams #1441\n"));
        MEDIA_OBJECTS.add(new MediaObject("MVVM and LiveData",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
                "https://media.pocketgamer.com/artwork/na-30672-1605595336/viber_image_2020-11-17_14-40-414_jpg_1280.jpg",
                "OMG! SHIELD YOUR ENTIRE HEALTHBAR WITH SUPER SHIELD MORDEKAISER"));

        MEDIA_OBJECTS.add(new MediaObject("REST API, Retrofit2, MVVM Course SUMMARY",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
                "https://www.researchgate.net/profile/Yubo-Kou/publication/343696773/figure/fig1/AS:925549996298245@1597679723345/Screenshot-of-League-of-Legends-LoL-affords-a-variety-of-ways-for-players-to-express.png",
                "He Spent $60000 Gifting Subs - Best of LoL Streams #1442"));
        MEDIA_OBJECTS.add(new MediaObject("Sending Data to a New Activity with Intent Extras",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
                "https://mmos.com/wp-content/gallery/league-of-legends/League-of-Legends-Early.jpg",
                "They Wanted To Dive BABUS - Best of LoL Streams #1441\n"));
        MEDIA_OBJECTS.add(new MediaObject("MVVM and LiveData",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
                "https://media.pocketgamer.com/artwork/na-30672-1605595336/viber_image_2020-11-17_14-40-414_jpg_1280.jpg",
                "OMG! SHIELD YOUR ENTIRE HEALTHBAR WITH SUPER SHIELD MORDEKAISER"));

        MEDIA_OBJECTS.add(new MediaObject("REST API, Retrofit2, MVVM Course SUMMARY",
                "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
                "https://www.researchgate.net/profile/Yubo-Kou/publication/343696773/figure/fig1/AS:925549996298245@1597679723345/Screenshot-of-League-of-Legends-LoL-affords-a-variety-of-ways-for-players-to-express.png",
                "He Spent $60000 Gifting Subs - Best of LoL Streams #1442"));





    }

    public void Release() {
        if (mRecyclerView != null)
            mRecyclerView.releasePlayer();
    }

    @Override
    public void onDestroy() {
        Release();
        super.onDestroy();
    }


}

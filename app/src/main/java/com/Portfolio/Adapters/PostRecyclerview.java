package com.Portfolio.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Portfolio.Modules.MediaObject;
import com.Portfolio.foxgaming.GamerProfileActivity;
import com.Portfolio.foxgaming.R;
import com.bumptech.glide.RequestManager;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostRecyclerview extends RecyclerView.Adapter<PostRecyclerview.MyViewHolder> {
    private Context context;
    private RequestManager requestManager;
    private ArrayList<MediaObject> mediaObjects;


    public PostRecyclerview(ArrayList<MediaObject> mediaObjects, RequestManager requestManager) {
        this.mediaObjects = mediaObjects;
        this.requestManager = requestManager;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView storiesImg;
        public TextView description;
        public FrameLayout media_container;
        public ImageView thumbnail, volumeControl;
        public ProgressBar progressBar;
        public View parent;
        public RequestManager requestManager;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            storiesImg = itemView.findViewById(R.id.storiesImg);
            parent = itemView;
            media_container = itemView.findViewById(R.id.media_container);
            description = itemView.findViewById(R.id.description);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            progressBar = itemView.findViewById(R.id.progressBar);
            volumeControl = itemView.findViewById(R.id.volume_control);
        }

        public void onBind(MediaObject mediaObject, RequestManager requestManager) {
            this.requestManager = requestManager;
            parent.setTag(this);

            this.requestManager
                    .load(mediaObject.getThumbnail())
                    .into(thumbnail);
            this.requestManager
                    .load("https://i.ytimg.com/vi/G8t44O_SIj8/maxresdefault.jpg")
                    .into(storiesImg);
            description.setText(mediaObject.getDescription());
            storiesImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, GamerProfileActivity.class));

                }
            });
        }
    }

    @NonNull
    @Override
    public PostRecyclerview.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.post_item_layout, parent, false);

        // Return a new holder instance
        return new MyViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostRecyclerview.MyViewHolder holder, int position) {
        holder.onBind(mediaObjects.get(position), requestManager);


    }

    @Override
    public int getItemCount() {
        return mediaObjects.size();
    }


}

package com.Portfolio.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Portfolio.Modules.StoriesDashboardModule;
import com.Portfolio.foxgaming.R;
import com.Portfolio.Interfaces.onStorieItemClick;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoriesRecyclerview extends RecyclerView.Adapter<StoriesRecyclerview.MyViewHolder> {
    private Context context;
    private ArrayList<StoriesDashboardModule> Stories;
    private onStorieItemClick StorieItemClick;

    public StoriesRecyclerview(ArrayList<StoriesDashboardModule> Stories, onStorieItemClick StorieItemClick) {
        this.Stories = Stories;
        this.StorieItemClick = StorieItemClick;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView storiesImg;
        private onStorieItemClick StorieItemClick;

        public MyViewHolder(@NonNull View itemView, onStorieItemClick StorieItemClick) {
            super(itemView);
            storiesImg = itemView.findViewById(R.id.storiesImg);
            this.StorieItemClick = StorieItemClick;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StorieItemClick.Click(getAdapterPosition());
                }
            });

        }
    }

    @NonNull
    @Override
    public StoriesRecyclerview.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.stories_item_layout, parent, false);

        // Return a new holder instance
        return new MyViewHolder(contactView, StorieItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesRecyclerview.MyViewHolder holder, int position) {
        String imageUri = "https://yt3.ggpht.com/TRAMvn6U39p-1bHSDWFMrkYFH2_TwbXyv-MyCBoHMt3cK2KE0DyfEnUaRUAHC2i02Gsf3S_4wA=s88-c-k-c0x00ffffff-no-rj";
        Picasso.with(context).load(imageUri).noFade().into(holder.storiesImg);
    }

    @Override
    public int getItemCount() {
        return Stories.size();
    }


}

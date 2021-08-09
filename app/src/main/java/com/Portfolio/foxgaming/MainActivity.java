package com.Portfolio.foxgaming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

import com.Portfolio.Adapters.StoriesRecyclerview;
import com.Portfolio.Adapters.ViewPagerAdapter;
import com.Portfolio.Fragments.AllgamesTab;
import com.Portfolio.Fragments.LeagueOfLegendsTab;
import com.Portfolio.Fragments.NewsTab;
import com.Portfolio.Fragments.ValorantTab;
import com.Portfolio.Modules.StoriesContent;
import com.Portfolio.Modules.StoriesDashboardModule;
import com.Portfolio.Modules.Tabs;
import com.Portfolio.Interfaces.onStorieItemClick;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements onStorieItemClick {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private final ArrayList<Tabs> Fragments = new ArrayList<>();
    private ArrayList<StoriesDashboardModule> Stories = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FindViewById();
        AddFragmets();
        FillStories();
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(createCardAdapter());
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(Fragments.get(position).getTitle())).attach();

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.StoriesRecyclerView);
        // Create adapter passing in the sample user data
        StoriesRecyclerview adapter = new StoriesRecyclerview(Stories, this);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void Click(int position) {
        startActivity(new Intent(this, StoriesContentActivity.class));
    }


    interface FragmentLifecycle {
        void onPauseFragment();
    }

    private void FillStories() {
        ArrayList<StoriesContent> list = new ArrayList<>();
        Stories.add(new StoriesDashboardModule("aa"));
        Stories.add(new StoriesDashboardModule("aa"));
        Stories.add(new StoriesDashboardModule("aa"));
        Stories.add(new StoriesDashboardModule("aa"));
        Stories.add(new StoriesDashboardModule("aa"));
        Stories.add(new StoriesDashboardModule("aa"));
        Stories.add(new StoriesDashboardModule("aa"));
        Stories.add(new StoriesDashboardModule("aa"));
        Stories.add(new StoriesDashboardModule("aa"));
        Stories.add(new StoriesDashboardModule("aa"));
        Stories.add(new StoriesDashboardModule("aa"));
        Stories.add(new StoriesDashboardModule("aa"));
        Stories.add(new StoriesDashboardModule("aa"));


    }

    private void AddFragmets() {
        Fragments.add(new Tabs(new AllgamesTab(), "All Games"));
        Fragments.add(new Tabs(new LeagueOfLegendsTab(), "League Of Legends"));
        Fragments.add(new Tabs(new ValorantTab(), "Valorant"));
        Fragments.add(new Tabs(new NewsTab(), "News"));
    }

    private ViewPagerAdapter createCardAdapter() {
        return new ViewPagerAdapter(this, Fragments);
    }

    private void FindViewById() {
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);
    }

}



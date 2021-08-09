package com.Portfolio.foxgaming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.Portfolio.Adapters.ViewPagerAdapter;
import com.Portfolio.Fragments.AllgamesTab;
import com.Portfolio.Fragments.GamerProfileFragments.AboutTab;
import com.Portfolio.Fragments.GamerProfileFragments.LinksTab;
import com.Portfolio.Fragments.GamerProfileFragments.PostsTab;
import com.Portfolio.Fragments.GamerProfileFragments.StatsTab;
import com.Portfolio.Fragments.GamerProfileFragments.VideosTab;
import com.Portfolio.Fragments.LeagueOfLegendsTab;
import com.Portfolio.Fragments.NewsTab;
import com.Portfolio.Fragments.ValorantTab;
import com.Portfolio.Modules.Tabs;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class GamerProfileActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private final ArrayList<Tabs> Fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamer_profile);
        FindViewById();
        AddFragmets();

        viewPager.setAdapter(createCardAdapter());
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(Fragments.get(position).getTitle())).attach();
    }

    private void AddFragmets() {
        Fragments.add(new Tabs(new PostsTab(), "Posts"));
        Fragments.add(new Tabs(new AllgamesTab(), "Videos"));
        Fragments.add(new Tabs(new AboutTab(), "About"));
        Fragments.add(new Tabs(new StatsTab(), "Stats"));
        Fragments.add(new Tabs(new LinksTab(), "Links"));

    }


    private ViewPagerAdapter createCardAdapter() {
        return new ViewPagerAdapter(this, Fragments);
    }

    private void FindViewById() {
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);
        findViewById(R.id.goback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        findViewById(R.id.followButton).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                ((TextView) findViewById(R.id.Followers))
                        .setText(
                                String.valueOf(
                                        Integer.parseInt(
                                                ((TextView) findViewById(R.id.Followers))
                                                        .getText()
                                                        .toString()
                                        ) + 1
                                )
                        );

            }
        });

    }
}
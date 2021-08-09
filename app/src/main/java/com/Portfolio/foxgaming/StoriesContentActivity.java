package com.Portfolio.foxgaming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.Portfolio.Adapters.StoriesViewAdapter;
import com.Portfolio.Adapters.StoriesViewPagerAdapter;
import com.Portfolio.Animation.ZoomOutPageTransformer;
import com.Portfolio.Interfaces.StoriesOnComplete;
import com.Portfolio.Modules.Stories;
import com.Portfolio.Modules.StoriesContent;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import jp.shts.android.storiesprogressview.StoriesProgressView;

public class StoriesContentActivity extends AppCompatActivity implements StoriesOnComplete {

    private ViewPager2 screenPager;
    private final List<Stories> StoriesData = new ArrayList<>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_stories_content);

        fillData();
//        findViewById(R.id.Profile).setOnClickListener(v ->
//                startActivity(new Intent(StoriesContentActivity.this, GamerProfileActivity.class)));

        // setup viewpager
        screenPager = findViewById(R.id.PagerMedia);
        StoriesViewAdapter storiesViewAdapter = new StoriesViewAdapter(StoriesData, this);
        screenPager.setPageTransformer(new ZoomOutPageTransformer());
        screenPager.setAdapter(storiesViewAdapter);


    }


    private void fillData() {
        ArrayList<StoriesContent> storiesContent = new ArrayList<>();
        storiesContent.add(new StoriesContent("https://images.unsplash.com/photo-1620127682229-33388276e540?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8c3VtbWVyJTIwYmVhY2h8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80", ""));
        storiesContent.add(new StoriesContent("https://i.pinimg.com/originals/1e/5e/53/1e5e53e9f6b0004e2b47bad5881fcd46.png", ""));
        storiesContent.add(new StoriesContent("https://wallpapercave.com/wp/wp4976074.jpg", ""));
        storiesContent.add(new StoriesContent("https://www.enjpg.com/img/2020/league-of-legends-11-scaled.jpg", ""));
        storiesContent.add(new StoriesContent("https://i.pinimg.com/originals/87/a6/cf/87a6cf7fc3e36842697905cc27816d1c.jpg", ""));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));
        StoriesData.add(new Stories("", "", storiesContent));

    }


    @Override
    public void Complete(int position) {
        if (StoriesData.size() - 1 > position) {

            screenPager.setCurrentItem(position + 1, true);
        } else
            finish();
    }

    @Override
    public void PERV(int position) {

        screenPager.setCurrentItem(position - 1, true);

    }
}
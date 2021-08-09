package com.Portfolio.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.Portfolio.Modules.Tabs;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private final ArrayList<Tabs> Fragments;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Tabs> Fragments) {
        super(fragmentActivity);
        this.Fragments = Fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return Fragments.get(position).getTab();
    }

    @Override
    public int getItemCount() {
        return Fragments.size();
    }


}

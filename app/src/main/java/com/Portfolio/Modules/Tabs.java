package com.Portfolio.Modules;

import androidx.fragment.app.Fragment;

public class Tabs {
    Fragment Tab;
    String Title;

    public Tabs() {
    }

    public Tabs(Fragment tab, String title) {
        Tab = tab;
        Title = title;
    }

    public Fragment getTab() {
        return Tab;
    }

    public void setTab(Fragment tab) {
        Tab = tab;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}

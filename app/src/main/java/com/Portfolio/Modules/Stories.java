package com.Portfolio.Modules;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Stories implements Parcelable {
    String name, img;
    ArrayList<StoriesContent> Content;

    public Stories() {
    }

    public Stories(String name, String img, ArrayList<StoriesContent> content) {
        this.name = name;
        this.img = img;
        Content = content;
    }

    protected Stories(Parcel in) {
        name = in.readString();
        img = in.readString();
    }

    public static final Creator<Stories> CREATOR = new Creator<Stories>() {
        @Override
        public Stories createFromParcel(Parcel in) {
            return new Stories(in);
        }

        @Override
        public Stories[] newArray(int size) {
            return new Stories[size];
        }
    };

    public ArrayList<StoriesContent> getContent() {
        return Content;
    }

    public void setContent(ArrayList<StoriesContent> content) {
        Content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(img);
    }
}

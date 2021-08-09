package com.Portfolio.Modules;

public class StoriesContent {
    String ContentImgUri,ContentVideoUri;

    public StoriesContent() {
    }

    public StoriesContent(String contentImgUri, String contentVideoUri) {
        ContentImgUri = contentImgUri;
        ContentVideoUri = contentVideoUri;
    }

    public String getContentImgUri() {
        return ContentImgUri;
    }

    public void setContentImgUri(String contentImgUri) {
        ContentImgUri = contentImgUri;
    }

    public String getContentVideoUri() {
        return ContentVideoUri;
    }

    public void setContentVideoUri(String contentVideoUri) {
        ContentVideoUri = contentVideoUri;
    }
}


package com.deliCoin2.bean;

/**
 * Created by RUTH on 15/10/30.
 */
public class Pics {
    private String title;
    private String imageUrl;
    private String category;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString()
    {
        return "title:"+getTitle()+",imageUrl:"+getImageUrl();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

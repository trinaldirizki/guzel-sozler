package com.fit.guzelsozler.model;

/**
 * Created by trinaldi on 2/17/18.
 */

public class Quote {
    private String name;
    private String category;
    private boolean favorite;

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Quote(String name, boolean favorite) {
        this.name = name;
        this.favorite = favorite;
    }

    public Quote(String name, String category, boolean favorite) {
        this.name = name;
        this.category = category;
        this.favorite = favorite;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

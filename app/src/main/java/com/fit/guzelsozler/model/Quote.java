package com.fit.guzelsozler.model;

/**
 * Created by trinaldi on 2/17/18.
 */

public class Quote {
    private String name;
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Quote(String name, String category) {

        this.name = name;
        this.category = category;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

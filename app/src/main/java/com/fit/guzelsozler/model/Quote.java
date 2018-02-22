package com.fit.guzelsozler.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by trinaldi on 2/17/18.
 */

@Table(name = "Quotes")
public class Quote extends Model {
    @Column(name = "Name")
    private String name;
    @Column(name = "Category")
    private String category;
    @Column(name = "Favorite")
    private boolean favorite;

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Quote() {
        super();
    }

    public Quote(String name, String category, boolean favorite) {
        super();
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


    public static List<Quote> getAll(){
        return new Select().from(Quote.class).orderBy("Name ASC").execute();
    }

    public static List<Quote> getRandom(){
        return new Select().from(Quote.class).limit(50).orderBy("RANDOM()").execute();
    }
}

package com.fit.guzelsozler.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.fit.guzelsozler.model.Quote;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by trinaldi on 2/19/18.
 */

public class SharedPreferenceUtil {
    private static final String PREFS_NAME = "GuzelSozlerApp";
    private static final String FAVORITES = "FavoriteQuote";

    public SharedPreferenceUtil() {
        super();
    }

    private void saveFavorites(Context context, List<Quote> favorites) {
        SharedPreferences preferences;
        SharedPreferences.Editor editor;

        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);
        editor.putString(FAVORITES, jsonFavorites);
        editor.putString("TEST", favorites.toString());
        Log.i("Tag", jsonFavorites);
        editor.commit();
    }

    private ArrayList<Quote> getFavorites(Context context) {
        SharedPreferences preferences;
        List<Quote> favorites;

        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        if (preferences.contains(FAVORITES)) {
            String jsonFavorites = preferences.getString(FAVORITES, null);
            Gson gson = new Gson();
            Quote[] favoriteItems = gson.fromJson(jsonFavorites, Quote[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<>(favorites);
        } else {
            return null;
        }

        return (ArrayList<Quote>) favorites;
    }

    public void addFavorite(Context context, Quote quote) {
        List<Quote> favorites = getFavorites(context);
        if (favorites == null) {
            favorites = new ArrayList<>();
        }
        favorites.add(quote);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, Quote quote) {
        ArrayList<Quote> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(quote);
            saveFavorites(context, favorites);
        }
    }
}

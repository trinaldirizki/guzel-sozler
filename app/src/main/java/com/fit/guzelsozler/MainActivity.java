package com.fit.guzelsozler;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;
import com.facebook.stetho.Stetho;
import com.fit.guzelsozler.fragment.CategoryFragment;
import com.fit.guzelsozler.fragment.CategoryRecyclerFragment;
import com.fit.guzelsozler.fragment.FavoriteFragment;
import com.fit.guzelsozler.fragment.HomeFragment;
import com.fit.guzelsozler.fragment.HomeRecyclerFragment;
import com.fit.guzelsozler.model.Quote;
import com.fit.guzelsozler.util.DictionaryUtil;
import com.fit.guzelsozler.util.FragmentUtil;
import com.fit.guzelsozler.util.SharedPreferenceUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            LinearLayout layout = (LinearLayout) findViewById(R.id.fragment_base);
            layout.removeAllViews();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportActionBar().setSubtitle(R.string.title_home);
                    FragmentUtil.open(getFragmentManager(), R.id.fragment_base, new HomeRecyclerFragment());
                    return true;
                case R.id.navigation_category:
                    getSupportActionBar().setSubtitle(R.string.title_category);
                    FragmentUtil.open(getFragmentManager(), R.id.fragment_base, new CategoryRecyclerFragment());
                    return true;
                case R.id.navigation_favorite:
                    getSupportActionBar().setSubtitle(R.string.title_favorite);
                    FragmentUtil.open(getFragmentManager(), R.id.fragment_base, new FavoriteFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setSubtitle(getString(R.string.title_home));
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initiliazeApp();
    }

    public void initiliazeApp() {
        ActiveAndroid.beginTransaction();
        try {
            DictionaryUtil dictionaryUtil = new DictionaryUtil(this);
            dictionaryUtil.initDictionary();
            String[] categories = getResources().getStringArray(R.array.array_category);
            for (String s : categories) {
                String[] items = getResources().getStringArray((int) dictionaryUtil.getValue(s));
                for (String item : items) {
                    Quote quote = new Quote();
                    quote.setCategory(s);
                    quote.setName(item);
                    quote.setFavorite(false);
                    quote.save();
                }
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }

}

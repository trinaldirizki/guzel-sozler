package com.fit.guzelsozler;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.activeandroid.Configuration.Builder;
import com.facebook.stetho.Stetho;
import com.fit.guzelsozler.fragment.CategoryFragment;
import com.fit.guzelsozler.fragment.CategoryListFragment;
import com.fit.guzelsozler.fragment.CategoryRecyclerFragment;
import com.fit.guzelsozler.fragment.CreditsFragment;
import com.fit.guzelsozler.fragment.FavoriteFragment;
import com.fit.guzelsozler.fragment.FavoriteRecyclerFragment;
import com.fit.guzelsozler.fragment.HomeFragment;
import com.fit.guzelsozler.fragment.HomeRecyclerFragment;
import com.fit.guzelsozler.fragment.QuoteRecyclerFragment;
import com.fit.guzelsozler.model.Quote;
import com.fit.guzelsozler.util.DataUtil;
import com.fit.guzelsozler.util.DictionaryUtil;
import com.fit.guzelsozler.util.FragmentUtil;
import com.fit.guzelsozler.util.SharedPreferenceUtil;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, getResources().getString(R.string.admob_app_id));
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        layout = (LinearLayout) findViewById(R.id.fragment_base);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setSubtitle(getString(R.string.title_home));
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        DataUtil.checkDatabase(this);
        FragmentUtil.open(getFragmentManager(), R.id.fragment_base, new HomeRecyclerFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_credits:
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setSubtitle(R.string.title_credits);
                    FragmentUtil.replace(getFragmentManager(), R.id.fragment_base, new CreditsFragment());
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            clearView();
            if (getSupportActionBar() != null) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        getSupportActionBar().setSubtitle(R.string.title_home);
                        FragmentUtil.replace(getFragmentManager(), R.id.fragment_base, new HomeRecyclerFragment());
                        showAd();
                        return true;
                    case R.id.navigation_category:
                        getSupportActionBar().setSubtitle(R.string.title_category);
                        FragmentUtil.replace(getFragmentManager(), R.id.fragment_base, new CategoryRecyclerFragment());
                        showAd();
                        return true;
                    case R.id.navigation_favorite:
                        getSupportActionBar().setSubtitle(R.string.title_favorite);
                        FragmentUtil.replace(getFragmentManager(), R.id.fragment_base, new FavoriteRecyclerFragment());
                        showAd();
                        return true;
                }
            }
            return false;
        }
    };

    private void showAd() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }

    public void clearView() {
        layout.removeAllViews();
    }
}

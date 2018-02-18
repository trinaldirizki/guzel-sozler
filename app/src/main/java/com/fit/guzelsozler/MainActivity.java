package com.fit.guzelsozler;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fit.guzelsozler.fragment.CategoryFragment;
import com.fit.guzelsozler.fragment.FavoriteFragment;
import com.fit.guzelsozler.fragment.HomeFragment;
import com.fit.guzelsozler.fragment.HomeRecyclerFragment;
import com.fit.guzelsozler.util.FragmentUtil;

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
                    FragmentUtil.open(getFragmentManager(),R.id.fragment_base,new HomeRecyclerFragment());
                    return true;
                case R.id.navigation_category:
                    getSupportActionBar().setSubtitle(R.string.title_category);
                    FragmentUtil.open(getFragmentManager(),R.id.fragment_base,new CategoryFragment());
                    return true;
                case R.id.navigation_favorite:
                    getSupportActionBar().setSubtitle(R.string.title_favorite);
                    FragmentUtil.open(getFragmentManager(),R.id.fragment_base,new FavoriteFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setSubtitle(getString(R.string.title_home));
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}

package com.fit.guzelsozler.fragment;

import android.view.View;

import com.fit.guzelsozler.R;

/**
 * Created by trinaldi on 2/16/18.
 */

public class FavoriteFragment extends BaseFragment {

    private static final String FAVORITE_FRAGMENT = "FavoriteFragment";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_favorite;
    }

    @Override
    protected void setViewComponents(View view) {

    }

    @Override
    public String getFragmentTag() {
        return FAVORITE_FRAGMENT;
    }
}

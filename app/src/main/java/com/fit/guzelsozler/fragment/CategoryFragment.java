package com.fit.guzelsozler.fragment;

import android.view.View;

import com.fit.guzelsozler.R;

/**
 * Created by trinaldi on 2/16/18.
 */

public class CategoryFragment extends BaseFragment {

    private static final String CATEGORY_FRAGMENT = "CategoryFragment";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    protected void setViewComponents(View view) {

    }

    @Override
    public String getFragmentTag() {
        return CATEGORY_FRAGMENT;
    }
}

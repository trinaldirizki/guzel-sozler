package com.fit.guzelsozler.fragment;

import android.view.View;

import com.fit.guzelsozler.R;
import com.fit.guzelsozler.fragment.BaseFragment;

/**
 * Created by trinaldi on 2/16/18.
 */

public class HomeFragment extends BaseFragment {

    private static final String HOME_FRAGMENT = "HomeFragment";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void setViewComponents(View view) {

    }

    @Override
    public String getFragmentTag() {
        return HOME_FRAGMENT;
    }
}

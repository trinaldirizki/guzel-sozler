package com.fit.guzelsozler.fragment;

import android.view.View;

import com.fit.guzelsozler.R;

/**
 * Created by trinaldi on 2/17/18.
 */

public class CreditsFragment extends BaseFragment {

    private static final String CREDITS_FRAGMENT = CreditsFragment.class.getSimpleName();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_credits;
    }

    @Override
    protected void setViewComponents(View view) {

    }

    @Override
    public String getFragmentTag() {
        return CREDITS_FRAGMENT;
    }
}

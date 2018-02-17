package com.fit.guzelsozler.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by trinaldi on 15.02.2018.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        setViewComponents(view);
        return view;
    }

    protected abstract int getLayoutId();
    protected abstract void setViewComponents(View view);
    public abstract String getFragmentTag();
}
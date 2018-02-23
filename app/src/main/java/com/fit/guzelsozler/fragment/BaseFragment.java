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

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        this.view = view;
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        setViewComponents(view);
        super.onActivityCreated(savedInstanceState);
    }

    protected abstract int getLayoutId();

    protected abstract void setViewComponents(View view);

    public abstract String getFragmentTag();
}
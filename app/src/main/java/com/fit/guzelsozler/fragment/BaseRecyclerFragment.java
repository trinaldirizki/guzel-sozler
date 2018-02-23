package com.fit.guzelsozler.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by fidel on 15.02.2018.
 */

public abstract class BaseRecyclerFragment extends BaseFragment {

    RecyclerView recyclerView;

    @Override
    protected void setViewComponents(View view) {
        recyclerView = view.findViewById(getRecyclerId());
        setRecyclerViewData();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(getAdapter());
        setListViewComponents(view);
    }

    protected abstract void setListViewComponents(View view);

    protected abstract int getRecyclerId();

    protected abstract RecyclerView.Adapter getAdapter();

    protected abstract void setRecyclerViewData();
}

package com.fit.guzelsozler.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;

import com.fit.guzelsozler.R;

/**
 * Created by trinaldi on 2/17/18.
 */

public class CategoryRecyclerFragment extends BaseRecyclerFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    public String getFragmentTag() {
        return CategoryRecyclerFragment.class.getSimpleName();
    }

    @Override
    protected void setListViewComponents(View view) {

    }

    @Override
    protected int getRecyclerId() {
        return R.id.recycler_category;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return null
    }

    @Override
    protected void setRecyclerViewData() {

    }
}

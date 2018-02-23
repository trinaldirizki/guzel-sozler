package com.fit.guzelsozler.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fit.guzelsozler.R;
import com.fit.guzelsozler.adapter.QuoteAdapter;
import com.fit.guzelsozler.model.Quote;
import com.fit.guzelsozler.util.SharedPreferenceUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by trinaldi on 2/17/18.
 */

public class HomeRecyclerFragment extends BaseRecyclerFragment {

    List<Quote> mQuoteList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public String getFragmentTag() {
        return HomeRecyclerFragment.class.getSimpleName();
    }

    @Override
    protected void setListViewComponents(View view) {

    }

    @Override
    protected int getRecyclerId() {
        return R.id.recycler_home;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new QuoteAdapter(getActivity(), mQuoteList);
    }

    @Override
    protected void setRecyclerViewData() {
        mQuoteList = Quote.getRandom();
    }
}

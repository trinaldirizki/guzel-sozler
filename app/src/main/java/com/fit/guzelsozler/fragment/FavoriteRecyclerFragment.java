package com.fit.guzelsozler.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fit.guzelsozler.MainActivity;
import com.fit.guzelsozler.R;
import com.fit.guzelsozler.adapter.QuoteAdapter;
import com.fit.guzelsozler.model.Quote;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trinaldi on 2/17/18.
 */

public class FavoriteRecyclerFragment extends BaseRecyclerFragment {

    List<Quote> mQuoteList;

    /*@Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            actionBar.setSubtitle(R.string.title_favorite);
        }
    }*/

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_favorite;
    }

    @Override
    public String getFragmentTag() {
        return FavoriteRecyclerFragment.class.getSimpleName();
    }

    @Override
    protected void setListViewComponents(View view) {

    }

    @Override
    protected int getRecyclerId() {
        return R.id.recycler_favorite;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new QuoteAdapter(mQuoteList, (MainActivity) getActivity());
    }

    @Override
    protected void setRecyclerViewData() {
        mQuoteList = Quote.getFavorites();
    }
}

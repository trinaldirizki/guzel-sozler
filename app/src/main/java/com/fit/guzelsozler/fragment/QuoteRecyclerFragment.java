package com.fit.guzelsozler.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fit.guzelsozler.MainActivity;
import com.fit.guzelsozler.R;
import com.fit.guzelsozler.adapter.QuoteAdapter;
import com.fit.guzelsozler.model.Category;
import com.fit.guzelsozler.model.Quote;
import com.fit.guzelsozler.util.DataUtil;
import com.fit.guzelsozler.util.FragmentUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trinaldi on 2/23/18.
 */

public class QuoteRecyclerFragment extends BaseRecyclerFragment {

    List<Quote> mListQuote;
    static String categoryName;

    @Override
    protected void setListViewComponents(View view) {

    }

    @Override
    protected int getRecyclerId() {
        return R.id.recycler_quote;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new QuoteAdapter(mListQuote, (MainActivity) getActivity());
    }

    @Override
    protected void setRecyclerViewData() {
        mListQuote = Quote.getSingleCategory(categoryName);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_quote;
    }

    @Override
    public String getFragmentTag() {
        return QuoteRecyclerFragment.class.getSimpleName();
    }

    public static void getCategoryName(String c) {
        categoryName = c;
    }
}

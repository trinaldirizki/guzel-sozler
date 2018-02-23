package com.fit.guzelsozler.fragment;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fit.guzelsozler.R;
import com.fit.guzelsozler.adapter.QuoteAdapter;
import com.fit.guzelsozler.model.Quote;
import com.fit.guzelsozler.util.DataUtil;
import com.fit.guzelsozler.util.FragmentUtil;

import java.util.List;

/**
 * Created by trinaldi on 2/23/18.
 */

public class QuoteRecyclerFragment extends BaseRecyclerFragment {

    List<Quote> mListQuote;

    @Override
    protected void setListViewComponents(View view) {

    }

    @Override
    protected int getRecyclerId() {
        return R.id.fragment_base;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new QuoteAdapter(mListQuote);
    }

    @Override
    protected void setRecyclerViewData() {
        mListQuote = Quote.getSingleCategory();
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public String getFragmentTag() {
        return null;
    }
}

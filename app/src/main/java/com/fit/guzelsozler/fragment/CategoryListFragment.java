package com.fit.guzelsozler.fragment;

import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.app.ListFragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.fit.guzelsozler.R;

import java.util.ArrayList;

/**
 * Created by trinaldi on 2/23/18.
 */

public class CategoryListFragment extends ListFragment {

    public CategoryListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.array_category));
        setListAdapter(adapter);
//        getListView().setLayoutParams();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_base, new QuoteRecyclerFragment());
        transaction.commit();
    }

}

package com.fit.guzelsozler.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;

import com.fit.guzelsozler.MainActivity;
import com.fit.guzelsozler.R;
import com.fit.guzelsozler.adapter.CategoryAdapter;
import com.fit.guzelsozler.model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trinaldi on 2/17/18.
 */

public class CategoryRecyclerFragment extends BaseRecyclerFragment {

    List<Category> mListCategory;
    String[] mArrayCategory;

    /*@Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            actionBar.setSubtitle(R.string.title_category);
        }
    }*/

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
        return new CategoryAdapter(mListCategory, (MainActivity) getActivity());
    }

    @Override
    protected void setRecyclerViewData() {
        mListCategory = new ArrayList<>();
        mArrayCategory = getResources().getStringArray(R.array.array_category);
        for (String s : mArrayCategory)
            mListCategory.add(new Category(s));
    }
}

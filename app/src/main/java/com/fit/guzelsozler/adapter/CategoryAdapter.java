package com.fit.guzelsozler.adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.fit.guzelsozler.MainActivity;
import com.fit.guzelsozler.R;
import com.fit.guzelsozler.fragment.HomeRecyclerFragment;
import com.fit.guzelsozler.fragment.QuoteRecyclerFragment;
import com.fit.guzelsozler.model.Category;
import com.fit.guzelsozler.util.FragmentUtil;

import java.util.List;

/**
 * Created by trinaldi on 2/18/18.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private List<Category> mListCategory;
    private Handler layoutHandler = new Handler();
    private Runnable mRunnable;
    private MainActivity activity;

    public class CategoryHolder extends RecyclerView.ViewHolder {
        public Button buttonCategory;

        public CategoryHolder(View itemView) {
            super(itemView);
            buttonCategory = itemView.findViewById(R.id.button_category);
        }
    }

    public CategoryAdapter(List<Category> mListCategory, MainActivity activity) {
        this.mListCategory = mListCategory;
        this.activity = activity;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_button, parent, false);
        return new CategoryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {
        final Category category = mListCategory.get(position);
        final FragmentManager manager = ((Activity) holder.itemView.getContext()).getFragmentManager();
        holder.buttonCategory.setText(category.getName());
        holder.buttonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.clearView();
                Log.i("ButtonCategory", category.getName());
                QuoteRecyclerFragment.getCategoryName(category.getName());
                FragmentUtil.replace(manager, R.id.fragment_base, new QuoteRecyclerFragment());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListCategory.size();
    }


}

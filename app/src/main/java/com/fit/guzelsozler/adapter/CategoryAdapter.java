package com.fit.guzelsozler.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.fit.guzelsozler.R;
import com.fit.guzelsozler.fragment.QuoteRecyclerFragment;
import com.fit.guzelsozler.model.Category;
import com.fit.guzelsozler.util.FragmentUtil;

import java.util.List;

/**
 * Created by trinaldi on 2/18/18.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private List<Category> mListCategory;

    public class CategoryHolder extends RecyclerView.ViewHolder {
        public Button buttonCategory;


        public CategoryHolder(View itemView) {
            super(itemView);
            buttonCategory = itemView.findViewById(R.id.button_category);
        }
    }

    public CategoryAdapter(List<Category> mListCategory) {
        this.mListCategory = mListCategory;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_button, parent, false);
        return new CategoryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {
        Category category = mListCategory.get(position);
        holder.buttonCategory.setText(category.getName());
        holder.buttonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentUtil.open(((Activity) view.getContext()).getFragmentManager(), R.id.fragment_base, new QuoteRecyclerFragment());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListCategory.size();
    }


}

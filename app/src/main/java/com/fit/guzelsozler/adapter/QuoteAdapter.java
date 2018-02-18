package com.fit.guzelsozler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fit.guzelsozler.MainActivity;
import com.fit.guzelsozler.R;
import com.fit.guzelsozler.model.Quote;

import java.util.List;

/**
 * Created by trinaldi on 2/17/18.
 */

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteHolder> {

    private List<Quote> quoteList;

    public class QuoteHolder extends RecyclerView.ViewHolder {
        public TextView textQuote, textCategory;
        public ImageButton buttonCopy, buttonAddToFavorites, buttonShare;

        public QuoteHolder(View view) {
            super(view);
            textQuote = view.findViewById(R.id.text_quote);
            textCategory = view.findViewById(R.id.text_category);
            buttonCopy = view.findViewById(R.id.button_copy);
            buttonAddToFavorites = view.findViewById(R.id.button_add_to_favorites);
            buttonShare = view.findViewById(R.id.button_share);
        }
    }

    public QuoteAdapter(List<Quote> quoteList){
        this.quoteList = quoteList;
    }

    @Override
    public QuoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_card, parent, false);
        return new QuoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QuoteHolder holder, int position) {
        final Quote quote = quoteList.get(position);
        holder.textQuote.setText(quote.getName());
        holder.textCategory.setText(quote.getCategory());
        holder.buttonAddToFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Favorilerim'e eklendi", Toast.LENGTH_SHORT).show();
                quote.setFavorite(true);
            }
        });
        holder.buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Copy", Toast.LENGTH_SHORT).show();

            }
        });
        holder.buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Share", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return quoteList.size();
    }
}

package com.fit.guzelsozler.adapter;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.fit.guzelsozler.MainActivity;
import com.fit.guzelsozler.R;
import com.fit.guzelsozler.model.Quote;
import com.fit.guzelsozler.util.SharedPreferenceUtil;

import java.util.List;

/**
 * Created by trinaldi on 2/17/18.
 */

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteHolder> {

    List<Quote> quoteList;
    private static final String COPIED_QUOTE = "CopiedQuote";
    private Context context;
    SharedPreferenceUtil sharedPreferenceUtil;


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

    public QuoteAdapter(Context context, List<Quote> quoteList) {
        this.context = context;
        this.quoteList = quoteList;
        sharedPreferenceUtil = new SharedPreferenceUtil();
    }

    public Quote getItem(int position) {
        return quoteList.get(position);
    }

    @Override
    public QuoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_card, parent, false);
        return new QuoteHolder(itemView);


    }

    @Override
    public void onBindViewHolder(final QuoteHolder holder, int position) {
        final Quote quote = quoteList.get(position);
        holder.textQuote.setText(quote.getName());
        holder.textCategory.setText(quote.getCategory());
        holder.buttonAddToFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = holder.buttonAddToFavorites.getTag().toString();
                if (tag.equalsIgnoreCase("no_favorite_quote")) {
                    sharedPreferenceUtil.addFavorite(context, quote);
                    Toast.makeText(view.getContext(), R.string.title_added_to_favorites, Toast.LENGTH_SHORT).show();
                    holder.buttonAddToFavorites.setTag("favorite_quote");
                    holder.buttonAddToFavorites.setBackgroundResource(R.drawable.ic_favorite);
                } else {
                    sharedPreferenceUtil.removeFavorite(context, quote);
                    Toast.makeText(view.getContext(), R.string.title_removed_from_favorites, Toast.LENGTH_SHORT).show();
                    holder.buttonAddToFavorites.setTag("no_favorite_quote");
                    holder.buttonAddToFavorites.setBackgroundResource(R.drawable.ic_action_add_to_favorites);
                }
            }
        });
        holder.buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) view.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText(COPIED_QUOTE, quote.getName());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(view.getContext(), R.string.title_copied, Toast.LENGTH_SHORT).show();
            }
        });
        holder.buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, quote.getName());
                view.getContext().startActivity(Intent.createChooser(intent, view.getResources().getString(R.string.title_share)));
            }
        });

        if (checkFavoriteItem(quote)) {
            holder.buttonAddToFavorites.setBackgroundResource(R.drawable.ic_favorite);
            holder.buttonAddToFavorites.setTag("favorite_quote");
        } else {
            holder.buttonAddToFavorites.setBackgroundResource(R.drawable.ic_action_add_to_favorites);
            holder.buttonAddToFavorites.setTag("no_favorite_quote");
        }
    }

    public boolean checkFavoriteItem(Quote quote) {
        boolean check = false;
        List<Quote> favorites = sharedPreferenceUtil.getFavorites(context);
        if (favorites != null) {
            for (Quote q : favorites) {
                if (q.equals(quote)) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    public void add(Quote quote) {
        quoteList.add(quote);
        notifyDataSetChanged();
    }

    public void remove(Quote quote) {
        quoteList.remove(quote);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return quoteList.size();
    }
}

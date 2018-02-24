package com.fit.guzelsozler.adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fit.guzelsozler.MainActivity;
import com.fit.guzelsozler.R;
import com.fit.guzelsozler.fragment.FavoriteRecyclerFragment;
import com.fit.guzelsozler.fragment.QuoteRecyclerFragment;
import com.fit.guzelsozler.model.Quote;
import com.fit.guzelsozler.util.FragmentUtil;

import java.util.List;

/**
 * Created by trinaldi on 2/17/18.
 */

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteHolder> {

    private List<Quote> quoteList;
    private static final String COPIED_QUOTE = "CopiedQuote";
    private MainActivity activity;


    class QuoteHolder extends RecyclerView.ViewHolder {
        TextView textQuote, textCategory;
        ImageButton buttonCopy, buttonAddToFavorites, buttonShare;

        QuoteHolder(View view) {
            super(view);
            textQuote = view.findViewById(R.id.text_quote);
            textCategory = view.findViewById(R.id.text_category);
            buttonCopy = view.findViewById(R.id.button_copy);
            buttonAddToFavorites = view.findViewById(R.id.button_add_to_favorites);
            buttonShare = view.findViewById(R.id.button_share);
        }
    }

    public QuoteAdapter(List<Quote> quoteList, MainActivity activity) {
        this.quoteList = quoteList;
        this.activity = activity;
    }

    @Override
    public QuoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_card, parent, false);
        return new QuoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final QuoteHolder holder, final int position) {
        final Quote quote = quoteList.get(position);
        final FragmentManager manager = ((Activity) holder.itemView.getContext()).getFragmentManager();
        holder.textQuote.setText(quote.getName());
        holder.textCategory.setText(quote.getCategory());
        holder.textCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), R.string.category_click_info, Toast.LENGTH_SHORT).show();
            }
        });
        holder.textCategory.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                activity.clearView();
                if (activity.getSupportActionBar() != null) {
                    activity.getSupportActionBar().setSubtitle(quote.getCategory());
                }
                QuoteRecyclerFragment.getCategoryName(quote.getCategory());
                FragmentUtil.replace(manager, R.id.fragment_base, new QuoteRecyclerFragment());
                return true;
            }
        });
        holder.buttonAddToFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = holder.buttonAddToFavorites.getTag().toString();
                if (tag.equalsIgnoreCase("no_favorite_quote")) {
                    quote.setFavorite(true);
                    Toast.makeText(view.getContext(), R.string.title_added_to_favorites, Toast.LENGTH_SHORT).show();
                    holder.buttonAddToFavorites.setTag("favorite_quote");
                    holder.buttonAddToFavorites.setBackgroundResource(R.drawable.ic_favorite);
                } else {
                    quote.setFavorite(false);
                    Toast.makeText(view.getContext(), R.string.title_removed_from_favorites, Toast.LENGTH_SHORT).show();
                    holder.buttonAddToFavorites.setTag("no_favorite_quote");
                    holder.buttonAddToFavorites.setBackgroundResource(R.drawable.ic_action_add_to_favorites);
                }

                refreshFavorites(view);
            }
        });
        holder.buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) view.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText(COPIED_QUOTE, quote.getName());
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(clipData);
                }
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

    private boolean checkFavoriteItem(Quote quote) {
        return quote.isFavorite();
    }

    @Override
    public int getItemCount() {
        return quoteList.size();
    }

    private void refreshFavorites(View view) {
        FragmentManager manager = ((Activity) view.getContext()).getFragmentManager();
        FavoriteRecyclerFragment fragment = (FavoriteRecyclerFragment) manager.findFragmentByTag(FavoriteRecyclerFragment.class.getSimpleName());
        if (fragment != null) {
            FragmentUtil.refresh(manager, fragment);
        }
    }
}

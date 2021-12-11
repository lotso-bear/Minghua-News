package com.laioffer.tindernews.ui.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laioffer.tindernews.R;
import com.laioffer.tindernews.databinding.SearchNewsItemBinding;
import com.laioffer.tindernews.model.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SearchNewsAdapter extends RecyclerView.Adapter<SearchNewsAdapter.SearchNewsViewHolder> {

    private ItemCallBack itemCallback;

    interface ItemCallBack {
        void onOpenDetails(Article article);
    }

    // 1. Supporting data:
    private List<Article> articles = new ArrayList<>();

    public void setArticles(List<Article> newsList) {
        articles.clear();
        articles.addAll(newsList);
        notifyDataSetChanged();
    }

    public void setItemCallback(ItemCallBack itemCallback) {
        this.itemCallback = itemCallback;
    }


    @NonNull
    @Override
    public SearchNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_news_item, parent, false);
        return new SearchNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchNewsViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.itemTitleTextView.setText(article.title);
        Picasso.get().load(article.urlToImage).resize(200, 200).into(holder.itemImageView);
        holder.itemView.setOnClickListener(v -> itemCallback.onOpenDetails(article));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    // 2. SearchNewsViewHolder:
    // TODO

    // 3. Adapter overrides:
    // TODO
    public static class SearchNewsViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImageView;
        TextView itemTitleTextView;
        public SearchNewsViewHolder(@NonNull View itemView) { //itemView comes from search_news_item.xml
            super(itemView);
            SearchNewsItemBinding binding = SearchNewsItemBinding.bind(itemView);
            itemImageView = binding.searchItemImage;
            itemTitleTextView = binding.searchItemTitle;
        }
    }
}

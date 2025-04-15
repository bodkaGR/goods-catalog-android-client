package com.bodkasoft.goodscatalogclient.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bodkasoft.goodscatalogclient.R;
import com.bodkasoft.goodscatalogclient.adapter.callback.OnCategoryItem;
import com.bodkasoft.goodscatalogclient.api.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private final List<Category> categoryList;
    private final OnCategoryItem callback;

    public CategoryAdapter(List<Category> categories, OnCategoryItem callback) {
        this.categoryList = categories;
        this.callback = callback;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list_item, parent, false);
        return new CategoryViewHolder(view, callback);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);

        holder.title.setText(category.getName());
        holder.title.setTextColor(Color.BLACK);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public CategoryViewHolder(@NonNull View itemView, OnCategoryItem callback) {
            super(itemView);
            title = itemView.findViewById(R.id.title);

            itemView.setOnClickListener(view -> {
                if (callback != null) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        callback.onItemClick(pos);
                    }
                }
            });
        }
    }
}

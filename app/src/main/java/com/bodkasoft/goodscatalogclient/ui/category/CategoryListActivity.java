package com.bodkasoft.goodscatalogclient.ui.category;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bodkasoft.goodscatalogclient.adapter.CategoryAdapter;
import com.bodkasoft.goodscatalogclient.api.model.Category;
import com.bodkasoft.goodscatalogclient.databinding.ActivityCategoryListBinding;
import com.bodkasoft.goodscatalogclient.viewmodel.CategoryViewModel;

public class CategoryListActivity extends AppCompatActivity {
    private ActivityCategoryListBinding binding;
    private CategoryViewModel viewModel;
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        binding.categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        setupObservers();
    }

    private void setupObservers() {
        viewModel.getAllCategories().observe(this, categories -> {
            if (categories != null) {
                adapter = new CategoryAdapter(categories, position -> {
                    Category selectedCategory = categories.get(position);
                    Intent intent = new Intent(this, CategoryDetailsActivity.class);
                    intent.putExtra("category_id", selectedCategory.getId());
                    startActivity(intent);
                });
                binding.categoryRecyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
package com.bodkasoft.goodscatalogclient.ui.category;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.bodkasoft.goodscatalogclient.R;
import com.bodkasoft.goodscatalogclient.api.model.Product;
import com.bodkasoft.goodscatalogclient.databinding.ActivityCategoryDetailsBinding;
import com.bodkasoft.goodscatalogclient.viewmodel.CategoryViewModel;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDetailsActivity extends AppCompatActivity {
    private ActivityCategoryDetailsBinding binding;
    private CategoryViewModel viewModel;
    private int selectedCategoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        selectedCategoryId = getIntent().getIntExtra("category_id", -1);

        setupObservers();
    }

    void setupObservers() {
        viewModel.getCategoryById(selectedCategoryId).observe(this, category -> {
            if (category != null) {
                binding.categoryTitle.setText(category.getName());
                binding.categoryDescription.setText(category.getDescription());
                List<String> categoriesProducts = category.getProducts().stream()
                        .map(Product::getName)
                        .collect(Collectors.toList());
                binding.productListText.setText(categoriesProducts.toString());
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
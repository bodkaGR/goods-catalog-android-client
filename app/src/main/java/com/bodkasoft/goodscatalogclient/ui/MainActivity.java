package com.bodkasoft.goodscatalogclient.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bodkasoft.goodscatalogclient.R;
import com.bodkasoft.goodscatalogclient.databinding.ActivityMainBinding;
import com.bodkasoft.goodscatalogclient.ui.category.CategoryListActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        setupAnimation();
        setupObservers();
    }

    private void setupObservers() {
        binding.categoriesButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryListActivity.class);
            startActivity(intent);
        });

        binding.productsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryListActivity.class);
            startActivity(intent);
        });
    }

    void setupAnimation() {
        ImageView robotImage = findViewById(binding.robotImage.getId());
        Animation moveAnim = AnimationUtils.loadAnimation(this, R.anim.move_up_down);
        robotImage.startAnimation(moveAnim);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
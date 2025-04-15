package com.bodkasoft.goodscatalogclient.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.bodkasoft.goodscatalogclient.api.ApiClient;
import com.bodkasoft.goodscatalogclient.api.model.Category;
import com.bodkasoft.goodscatalogclient.api.service.CategoryApiService;

import java.util.List;
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {
    private final CategoryApiService categoryApiService;

    public CategoryRepository() {
        this.categoryApiService = ApiClient.getCategoryApi();
    }

    public void getAllCategories(Consumer<List<Category>> callback) {
        categoryApiService.getAllCategories().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.accept(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.e("CategoryRepository", "Error", t);
            }
        });
    }

    public void getById(int id, Consumer<Category> callback) {
        categoryApiService.getById(id).enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.accept(response.body());
                }
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Log.e("CategoryRepository", "Error", t);
            }
        });
    }
}

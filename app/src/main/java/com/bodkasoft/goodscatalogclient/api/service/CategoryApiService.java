package com.bodkasoft.goodscatalogclient.api.service;

import com.bodkasoft.goodscatalogclient.api.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CategoryApiService {
    @GET("categories")
    Call<List<Category>> getAllCategories();

    @GET("categories/{categoryId}")
    Call<Category> getById(@Path("categoryId") Integer id);
}

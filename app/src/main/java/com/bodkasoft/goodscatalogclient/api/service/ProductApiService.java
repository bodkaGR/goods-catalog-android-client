package com.bodkasoft.goodscatalogclient.api.service;

import com.bodkasoft.goodscatalogclient.api.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApiService {
    @GET("products")
    Call<List<Product>> getAllProducts();
}

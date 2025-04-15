package com.bodkasoft.goodscatalogclient.api;

import com.bodkasoft.goodscatalogclient.api.service.CategoryApiService;
import com.bodkasoft.goodscatalogclient.api.service.ProductApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://10.0.2.2:8081/api/v1/";
    private static Retrofit retrofit = null;

    private static Retrofit getApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static CategoryApiService getCategoryApi() {
        return getApiService().create(CategoryApiService.class);
    }

    public static ProductApiService getProductApi() {
        return getApiService().create(ProductApiService.class);
    }
}

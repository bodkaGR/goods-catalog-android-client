package com.bodkasoft.goodscatalogclient.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bodkasoft.goodscatalogclient.api.model.Category;
import com.bodkasoft.goodscatalogclient.repository.CategoryRepository;

import java.util.List;

public class CategoryViewModel extends ViewModel {
    private final CategoryRepository categoryRepository = new CategoryRepository();
    private final MutableLiveData<List<Category>> categories = new MutableLiveData<>();
    private final MutableLiveData<Category> selectedCategory = new MutableLiveData<>();

    public LiveData<List<Category>> getAllCategories() {
        if (categories.getValue() == null) {
            categoryRepository.getAllCategories(categories::setValue);
        }
        return categories;
    }

    public LiveData<Category> getCategoryById(int id) {
        if (selectedCategory.getValue() == null) {
            categoryRepository.getById(id, selectedCategory::setValue);
        }
        return selectedCategory;
    }
}

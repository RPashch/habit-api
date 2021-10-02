package com.lyceum.habitapi.service;

import com.lyceum.habitapi.dao.CategoryRepository;
import com.lyceum.habitapi.exceptions.CategoryNotFoundException;
import com.lyceum.habitapi.models.Category;

public class CategoryService {

    private CategoryRepository categoryRepository;

    public Iterable<Category> findTop() {
        return categoryRepository.findTop();
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(long categoryId) {
        return categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(
                        "category with id " + categoryId + " not found!"));
    }
}

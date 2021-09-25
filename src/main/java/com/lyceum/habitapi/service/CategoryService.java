package com.lyceum.habitapi.service;

import com.lyceum.habitapi.dao.CategoryRepository;
import com.lyceum.habitapi.models.Category;

public class CategoryService {

    private CategoryRepository categoryRepository;

    public Iterable<Category> findTop() {
        return categoryRepository.findTop();
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
}

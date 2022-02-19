package com.lyceum.habitapi.service;


import com.lyceum.habitapi.dao.CategoryRepository;
import com.lyceum.habitapi.entities.CategoryEntity;
import com.lyceum.habitapi.models.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public Category getCategoryById(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();

        return createCategory(categoryEntity);
    }

    public List<Category> getCategories() {
        return StreamSupport
                .stream(categoryRepository.findAll().spliterator(), false)
                .map(categoryEntity -> createCategory(categoryEntity))
                .collect(Collectors.toList());
    }
    private Category createCategory(CategoryEntity categoryEntity) {
        return Category.builder()
                .id(categoryEntity.getId())
                .description(categoryEntity.getDescription())
                .isDefault(categoryEntity.isDefault())
                .title(categoryEntity.getTitle())
                .createdAt(categoryEntity.getCreatedAt())
                .build();
    }



}

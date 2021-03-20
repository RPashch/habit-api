package com.lyceum.habitapi.controllers;

import com.lyceum.habitapi.dao.CategoryRepository;
import com.lyceum.habitapi.models.Category;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/all")
    public HttpEntity<Iterable<Category>> getAllCategories() {

        Iterable<Category> categories = categoryRepository.findAll();

        return ResponseEntity.ok(categories);

    }
}

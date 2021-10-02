package com.lyceum.habitapi.controllers;

import com.lyceum.habitapi.models.Category;
import com.lyceum.habitapi.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public HttpEntity<Iterable<Category>> getAllCategories() {
        Iterable<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/top")
    public HttpEntity<Iterable<Category>> getTopCategories() {
        Iterable<Category> categories = categoryService.findTop();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{categoryId}")
    public HttpEntity<Category> findById(@PathVariable("categoryId") long categoryId) {
        Category category = categoryService.findById(categoryId);

        return ResponseEntity.ok(category);
    }

}

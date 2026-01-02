/**
 * ------------------------------------------------------------
 * Company     : Software Bakery Inc.
 * Author      : Sung Hyun Back
 * ------------------------------------------------------------
 *
 * © 2026 Software Bakery Inc. All rights reserved.
 */

package com.thesoftwarebakery.dining_qr_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thesoftwarebakery.dining_qr_service.data.Category;
import com.thesoftwarebakery.dining_qr_service.repository.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("v1/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable String id, @RequestBody Category updatingCategory) {
        return categoryRepository.findById(UUID.fromString(id))
                .map(category -> {
                    category.setName(updatingCategory.getName());
                    category.setDescription(updatingCategory.getDescription());
                    category.setType(updatingCategory.getType());
                    return categoryRepository.save(category);
                }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id) {
        categoryRepository.deleteById(UUID.fromString(id));
    }

}

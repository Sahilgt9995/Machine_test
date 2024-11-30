package com.java.machine_test.Controller;

import com.java.machine_test.Entity.*;
import com.java.machine_test.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.java.machine_test.Entity.Category;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "20") int size) {
        return categoryService.getAllCategories(PageRequest.of(page, size));
    }

    @GetMapping("/getCategoryById")
    public Optional<Category> getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/createCategory")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/deleteCategory")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }

    @PutMapping("/updateCategory")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        category.setId(id);
        return categoryService.saveCategory(category);
    }
}
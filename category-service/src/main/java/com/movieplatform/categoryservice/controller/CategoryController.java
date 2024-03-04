package com.movieplatform.categoryservice.controller;

import com.movieplatform.categoryservice.dto.CategoryDto;
import com.movieplatform.categoryservice.dto.request.CategoryCreateRequest;
import com.movieplatform.categoryservice.service.CategoryService;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@RestController
@RequestMapping("/v1/category")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<CategoryDto> categoryDtoList = categoryService.findAll();
        return ResponseEntity.ok(categoryDtoList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        CategoryDto categoryDto = categoryService.findById(id);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CategoryDto> findById(@PathVariable String name) {
        CategoryDto categoryDto = categoryService.findByName(name);
        return ResponseEntity.ok(categoryDto);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> create(CategoryCreateRequest categoryCreateRequest) {
        CategoryDto categoryDto = categoryService.createCategory(categoryCreateRequest);
        return ResponseEntity.ok(categoryDto);
    }


}

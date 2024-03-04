package com.movieplatform.categoryservice.service;

import com.movieplatform.categoryservice.dto.CategoryDto;
import com.movieplatform.categoryservice.dto.request.CategoryCreateRequest;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface CategoryService {
    CategoryDto createCategory(CategoryCreateRequest categoryCreateRequest);
    CategoryDto findById(Long id);
    CategoryDto findByName(String name);

    List<CategoryDto> findAll();
}

package com.movieplatform.categoryservice.service.impl;

import com.movieplatform.categoryservice.dto.CategoryDto;
import com.movieplatform.categoryservice.dto.request.CategoryCreateRequest;
import com.movieplatform.categoryservice.repository.CategoryRepository;
import com.movieplatform.categoryservice.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto createCategory(CategoryCreateRequest categoryCreateRequest) {
        return null;
    }

    @Override
    public CategoryDto findById(Long id) {
        return null;
    }

    @Override
    public CategoryDto findByName(String name) {
        return null;
    }

    @Override
    public List<CategoryDto> findAll() {
        return null;
    }
}

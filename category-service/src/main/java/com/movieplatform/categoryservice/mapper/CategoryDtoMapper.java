package com.movieplatform.categoryservice.mapper;

import com.movieplatform.categoryservice.dto.CategoryDto;
import com.movieplatform.categoryservice.dto.request.CategoryCreateRequest;
import com.movieplatform.categoryservice.model.Category;
import org.springframework.stereotype.Component;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Component
public class CategoryDtoMapper {

    public Category convertCreateDtoToEntity(CategoryCreateRequest categoryCreateRequest){
        return Category.builder()
                .name(categoryCreateRequest.getName())
                .build();
    }

    public CategoryDto convertEntityToDto(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}

package com.movieplatform.categoryservice.repository;

import com.movieplatform.categoryservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}

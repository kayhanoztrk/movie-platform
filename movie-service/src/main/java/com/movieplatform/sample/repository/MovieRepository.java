package com.movieplatform.sample.repository;

import com.movieplatform.sample.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByName(String name);
}

package com.movieplatform.movieservice.service;

import com.movieplatform.movieservice.dto.MovieCreateRequest;
import com.movieplatform.movieservice.dto.MovieDto;
import com.movieplatform.movieservice.dto.MovieUpdateRequest;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface MovieService {

    List<MovieDto> findAll();
    MovieDto findById(Long id);
    MovieDto findByName(String name);
    MovieDto createMovie(MovieCreateRequest movieCreateRequest);
    MovieDto updateMovie(Long id, MovieUpdateRequest movieUpdateRequest);
    void deleteMovie(Long movieId);
    MovieDto releaseMovie(Long movieId);
}

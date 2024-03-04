package com.movieplatform.sample.service;

import com.movieplatform.sample.dto.MovieCreateRequest;
import com.movieplatform.sample.dto.MovieDto;
import com.movieplatform.sample.dto.MovieUpdateRequest;

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

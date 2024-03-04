package com.movieplatform.movieservice.service.impl;

import com.movieplatform.movieservice.constants.ExceptionMessages;
import com.movieplatform.movieservice.constants.MovieStatus;
import com.movieplatform.movieservice.dto.MovieCreateRequest;
import com.movieplatform.movieservice.dto.MovieDto;
import com.movieplatform.movieservice.dto.MovieUpdateRequest;
import com.movieplatform.movieservice.exception.MovieNotFoundException;
import com.movieplatform.movieservice.mapper.MovieDtoMapper;
import com.movieplatform.movieservice.model.Movie;
import com.movieplatform.movieservice.repository.MovieRepository;
import com.movieplatform.movieservice.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
    private final MovieRepository movieRepository;
    private final MovieDtoMapper movieDtoMapper;

    public MovieServiceImpl(MovieRepository movieRepository, MovieDtoMapper movieDtoMapper) {
        this.movieRepository = movieRepository;
        this.movieDtoMapper = movieDtoMapper;
    }

    @Override
    public List<MovieDto> findAll() {
        return movieRepository.findAll()
                .stream()
                .map((movie) -> movieDtoMapper.convertEntityToDto(movie))
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto findById(Long id) {
        return movieRepository.findById(id)
                .map(movie -> movieDtoMapper.convertEntityToDto(movie))
                .orElseThrow(() -> new MovieNotFoundException(id + ExceptionMessages.MOVIE_NOT_FOUND));
    }

    @Override
    public MovieDto findByName(String name) {
        MovieDto movieDto = movieRepository.findByName(name)
                .map(movie -> movieDtoMapper.convertEntityToDto(movie))
                .orElseThrow(() -> new MovieNotFoundException(name + ExceptionMessages.MOVIE_NOT_FOUND));

        return movieDto;
    }

    @Override
    public MovieDto createMovie(MovieCreateRequest movieCreateRequest) {
        Movie movie = movieDtoMapper.convertCreateDtoToEntity(movieCreateRequest);
        Movie createdMovie = movieRepository.save(movie);
        return movieDtoMapper.convertEntityToDto(createdMovie);
    }

    @Override
    public MovieDto updateMovie(Long id, MovieUpdateRequest movieUpdateRequest) {
        Movie toMovie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id + ExceptionMessages.MOVIE_NOT_FOUND));

        toMovie.setName(movieUpdateRequest.getName());
        toMovie.setDescription(movieUpdateRequest.getDescription());
        toMovie.setReleaseDate(movieUpdateRequest.getReleaseDate());
        toMovie.setMovieStatus(movieUpdateRequest.getMovieStatus());

        Movie savedMovie = movieRepository.save(toMovie);

        return movieDtoMapper.convertEntityToDto(savedMovie);
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public MovieDto releaseMovie(Long movieId) {
        Movie toMovie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId + ExceptionMessages.MOVIE_NOT_FOUND));

        toMovie.setMovieStatus(MovieStatus.RELEASED);
        Movie movie = movieRepository.save(toMovie);
        return movieDtoMapper.convertEntityToDto(movie);
    }
}

package com.circuitbreaker.sample.service;

import com.movieplatform.movieservice.constants.MovieStatus;
import com.movieplatform.movieservice.dto.MovieDto;
import com.movieplatform.movieservice.mapper.MovieDtoMapper;
import com.movieplatform.movieservice.model.Movie;
import com.movieplatform.movieservice.repository.MovieRepository;
import com.movieplatform.movieservice.service.MovieService;
import com.movieplatform.movieservice.service.impl.MovieServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.time.Instant;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class MovieServiceTest {

    private MovieService movieService;
    private MovieRepository movieRepository;
    private MovieDtoMapper movieDtoMapper;
    private Movie movie;
    private MovieDto movieDto;
    @Before
    public void setUp(){
        movieRepository = Mockito.mock(MovieRepository.class);
        movieDtoMapper = Mockito.mock(MovieDtoMapper.class);
        movieService = new MovieServiceImpl(movieRepository, movieDtoMapper);
        movie = Movie.builder()
                .id(1L)
                .name("name")
                .description("description")
                .movieStatus(MovieStatus.RELEASED)
                .releaseDate(Date.from(Instant.now()))
                .build();

        movieDto = MovieDto.builder()
                .id(1L)
                .name("name")
                .description("desc")
                .movieStatus(MovieStatus.RELEASED)
                .releaseDate(Date.from(Instant.now()))
                .build();

        when(movieDtoMapper.convertEntityToDto(any(Movie.class)))
                .thenReturn(movieDto);

        when(movieRepository.findById(any(Long.class)))
                .thenReturn(Optional.of(movie));
    }

    @Test
    public void testFindById(){
        MovieDto responseMovieDto = movieService.findById(1L);
        Assert.assertNotNull(responseMovieDto);
        Assert.assertNotNull(responseMovieDto.getId());
        Assert.assertNotNull(responseMovieDto.getName());
        Assert.assertNotNull(responseMovieDto.getDescription());

        Mockito.verify(movieRepository, times(1)).findById(any(Long.class));
    }
}

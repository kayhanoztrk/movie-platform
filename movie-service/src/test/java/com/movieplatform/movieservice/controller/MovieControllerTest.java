package com.movieplatform.movieservice.controller;

import com.movieplatform.movieservice.constants.MovieStatus;
import com.movieplatform.movieservice.controller.MovieController;
import com.movieplatform.movieservice.dto.MovieDto;
import com.movieplatform.movieservice.service.MovieService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class MovieControllerTest {

    private MovieController movieController;
    private MovieService movieService;
    private MovieDto movieDto;
    @Before
    public void setUp(){
        movieService = Mockito.mock(MovieService.class);
        movieController = new MovieController(movieService);

        movieDto = MovieDto.builder()
                        .id(1L)
                        .name("name")
                        .description("description")
                        .releaseDate(Date.from(Instant.now()))
                        .movieStatus(MovieStatus.RELEASED)
                        .build();

        when(movieService.findById(any(Long.class)))
                .thenReturn(movieDto);
    }

    @Test
    public void testFindAll(){
        ResponseEntity<List<MovieDto>> movieDtoList = movieController.findAll();
        Assert.assertNotNull(movieDtoList);
        Assert.assertNotNull(movieDtoList.getBody());
        Assert.assertNotNull(movieDtoList.getStatusCode());

        Assert.assertEquals(HttpStatus.OK, movieDtoList.getStatusCode());
        Mockito.verify(movieService, Mockito.times(1)).findAll();
    }

    @Test
    public void testFindById(){
        ResponseEntity<MovieDto> movieDtoResponseEntity = movieController.findById(any(Long.class));
        Assert.assertNotNull(movieDtoResponseEntity);
        Assert.assertNotNull(movieDtoResponseEntity.getStatusCode());
        Assert.assertNotNull(movieDtoResponseEntity.getBody());

        Assert.assertEquals(HttpStatus.OK, movieDtoResponseEntity.getStatusCode());
        Mockito.verify(movieService, Mockito.times(1)).findById(any(Long.class));
    }
}

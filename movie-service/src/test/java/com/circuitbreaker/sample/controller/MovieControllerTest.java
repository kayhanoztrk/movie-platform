package com.circuitbreaker.sample.controller;

import com.movieplatform.movieservice.controller.MovieController;
import com.movieplatform.movieservice.dto.MovieDto;
import com.movieplatform.movieservice.service.MovieService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class MovieControllerTest {

    private MovieController movieController;
    private MovieService movieService;
    @Before
    public void setUp(){
        movieService = Mockito.mock(MovieService.class);
        movieController = new MovieController(movieService);
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
}

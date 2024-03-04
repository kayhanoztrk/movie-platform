package com.circuitbreaker.sample.dto;

import com.movieplatform.movieservice.constants.MovieStatus;
import com.movieplatform.movieservice.dto.MovieDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.Instant;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class MovieDtoTest {
    private MovieDto movieDto;

    @Before
    public void setUp(){
        movieDto = MovieDto.builder()
                .id(1L)
                .name("name")
                .description("description")
                .movieStatus(MovieStatus.RELEASED)
                .releaseDate(Date.from(Instant.now()))
                .build();
    }

    @Test
    public void testGetter(){
        Assert.assertNotNull(movieDto);
        Assert.assertNotNull(movieDto.getId());
        Assert.assertNotNull(movieDto.getName());
        Assert.assertNotNull(movieDto.getDescription());
        Assert.assertNotNull(movieDto.getMovieStatus());
        Assert.assertNotNull(movieDto.getReleaseDate());
    }
}

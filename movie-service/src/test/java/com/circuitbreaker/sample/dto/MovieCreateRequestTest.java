package com.circuitbreaker.sample.dto;

import com.movieplatform.movieservice.constants.MovieStatus;
import com.movieplatform.movieservice.dto.MovieCreateRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class MovieCreateRequestTest {

    private MovieCreateRequest movieCreateRequest;


    @Before
    public void setUp() {
        movieCreateRequest = MovieCreateRequest.builder()
                .name("movieName")
                .movieStatus(MovieStatus.RELEASED)
                .description("movieDescription")
                .releaseDate(Date.from(Instant.now()))
                .build();
    }

    @Test
    public void testGetter() {
        Assert.assertNotNull(movieCreateRequest);
        Assert.assertNotNull(movieCreateRequest.getName());
        Assert.assertNotNull(movieCreateRequest.getDescription());
        Assert.assertNotNull(movieCreateRequest.getReleaseDate());
        Assert.assertNotNull(movieCreateRequest.getMovieStatus());
    }
}

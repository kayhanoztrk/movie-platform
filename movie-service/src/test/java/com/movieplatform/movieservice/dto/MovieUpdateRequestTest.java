package com.movieplatform.movieservice.dto;

import com.movieplatform.movieservice.constants.MovieStatus;
import com.movieplatform.movieservice.dto.MovieUpdateRequest;
import com.movieplatform.movieservice.model.Movie;
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
public class MovieUpdateRequestTest {
    private MovieUpdateRequest movieUpdateRequest;

    @Before
    public void setUp(){
        movieUpdateRequest = MovieUpdateRequest.builder()
                .name("name")
                .description("description")
                .movieStatus(MovieStatus.RELEASED)
                .releaseDate(Date.from(Instant.now()))
                .build();
    }

    @Test
    public void testGetter(){
        Assert.assertNotNull(movieUpdateRequest);
        Assert.assertNotNull(movieUpdateRequest.getName());
        Assert.assertNotNull(movieUpdateRequest.getDescription());
        Assert.assertNotNull(movieUpdateRequest.getReleaseDate());
        Assert.assertNotNull(movieUpdateRequest.getMovieStatus());
    }
}

package com.circuitbreaker.sample.model;

import com.movieplatform.movieservice.constants.MovieStatus;
import com.movieplatform.movieservice.model.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class MovieTest {
    private Movie movie;

    @Before
    public void setUp(){
        movie = Movie.builder()
                .id(1L)
                .name("name")
                .description("description")
                .movieStatus(MovieStatus.RELEASED)
                .releaseDate(Date.from(Instant.now()))
                .build();
    }

    @Test
    public void testGetter(){
        Assert.assertNotNull(movie);
        Assert.assertNotNull(movie.getId());
        Assert.assertNotNull(movie.getName());
        Assert.assertNotNull(movie.getDescription());
        Assert.assertNotNull(movie.getMovieStatus());
        Assert.assertNotNull(movie.getReleaseDate());
    }
}

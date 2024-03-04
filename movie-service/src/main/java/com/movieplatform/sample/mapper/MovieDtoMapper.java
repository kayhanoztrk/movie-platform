package com.movieplatform.sample.mapper;

import com.movieplatform.sample.dto.MovieCreateRequest;
import com.movieplatform.sample.dto.MovieDto;
import com.movieplatform.sample.dto.MovieUpdateRequest;
import com.movieplatform.sample.model.Movie;
import org.springframework.stereotype.Component;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Component
public class MovieDtoMapper {

    public MovieDto convertEntityToDto(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .description(movie.getDescription())
                .movieStatus(movie.getMovieStatus())
                .releaseDate(movie.getReleaseDate())
                .build();
    }

    public Movie convertCreateDtoToEntity(MovieCreateRequest movieCreateRequest){
        return Movie.builder()
                .name(movieCreateRequest.getName())
                .description(movieCreateRequest.getDescription())
                .movieStatus(movieCreateRequest.getMovieStatus())
                .releaseDate(movieCreateRequest.getReleaseDate())
                .build();
    }

    public Movie convertUpdateDtoToEntity(MovieUpdateRequest movieUpdateRequest){
        return Movie.builder()
                .name(movieUpdateRequest.getName())
                .description(movieUpdateRequest.getDescription())
                .movieStatus(movieUpdateRequest.getMovieStatus())
                .releaseDate(movieUpdateRequest.getReleaseDate())
                .build();
    }
}

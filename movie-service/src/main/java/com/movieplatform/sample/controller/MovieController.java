package com.movieplatform.sample.controller;

import com.movieplatform.sample.dto.MovieCreateRequest;
import com.movieplatform.sample.dto.MovieDto;
import com.movieplatform.sample.dto.MovieUpdateRequest;
import com.movieplatform.sample.model.Movie;
import com.movieplatform.sample.service.MovieService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@RestController
@RequestMapping("/v1/movie")
public class MovieController {
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> findAll(){
        List<MovieDto> movieDtoList = movieService.findAll();
        return ResponseEntity.ok(movieDtoList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable Long id){
        MovieDto movieDto = movieService.findById(id);
        return ResponseEntity.ok(movieDto);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<MovieDto> findByName(@PathVariable String name){
        MovieDto movieDto = movieService.findByName(name);
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping("/create")
    public ResponseEntity<MovieDto> create(@RequestBody MovieCreateRequest movieCreateRequest){
        MovieDto movieDto= movieService.createMovie(movieCreateRequest);
        return ResponseEntity.ok(movieDto);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @RequestBody MovieUpdateRequest movieUpdateRequest){
        MovieDto updatedMovieDto = movieService.updateMovie(id, movieUpdateRequest);
        return ResponseEntity.ok(updatedMovieDto);
    }
}

package com.movieplatform.channelservice.client;

import com.movieplatform.channelservice.dto.response.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@FeignClient(name = "movie-service", path="/v1/movie")
public interface MovieServiceClient {
    @GetMapping
    ResponseEntity<List<MovieDto>> findAll();

    @GetMapping("/id/{id}")
    ResponseEntity<MovieDto> findById(@PathVariable Long id);

}

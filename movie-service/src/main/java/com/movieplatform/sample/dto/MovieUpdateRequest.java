package com.movieplatform.sample.dto;

import com.movieplatform.sample.constants.MovieStatus;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
@Builder
public class MovieUpdateRequest {
    private String name;
    private String description;
    private MovieStatus movieStatus;
    private Date releaseDate;
}

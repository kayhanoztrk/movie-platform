package com.movieplatform.movieservice.dto;

import com.movieplatform.movieservice.constants.MovieStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieCreateRequest {
    private String name;
    private String description;
    private MovieStatus movieStatus;
    private Date releaseDate;
}

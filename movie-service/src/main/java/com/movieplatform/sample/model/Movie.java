package com.movieplatform.sample.model;

import com.movieplatform.sample.constants.MovieStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Entity
@Table(name = "TT_MOVIE")
@Data
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private MovieStatus movieStatus;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;
}

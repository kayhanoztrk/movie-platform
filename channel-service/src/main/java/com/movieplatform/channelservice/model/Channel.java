package com.movieplatform.channelservice.model;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Entity
@Table(name = "TT_CHANNEL")
@Data
@Builder
public class Channel {

    private Long id;
    private String name;
    private List<String> movieList;
    private Date channelDate;
}

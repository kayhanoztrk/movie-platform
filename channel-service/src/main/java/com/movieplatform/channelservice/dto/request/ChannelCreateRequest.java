package com.movieplatform.channelservice.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
@Builder
public class ChannelCreateRequest {
    private String name;
    private List<String> movieList;
    private Date channelDate;
}

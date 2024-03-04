package com.movieplatform.channelservice.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
@Builder
public class ChannelUpdateRequest {
    private String name;
    private List<String> movieList;
}

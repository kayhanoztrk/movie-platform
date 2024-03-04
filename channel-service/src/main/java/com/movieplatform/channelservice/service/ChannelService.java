package com.movieplatform.channelservice.service;

import com.movieplatform.channelservice.dto.request.ChannelCreateRequest;
import com.movieplatform.channelservice.dto.response.ChannelDto;
import com.movieplatform.channelservice.dto.response.ChannelResponseDto;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface ChannelService {
    List<ChannelResponseDto> findAll();
    ChannelDto findAllMoviesInChannel(Long channelId);
    ChannelResponseDto findById(Long id);
    ChannelResponseDto createChannel(ChannelCreateRequest channelCreateRequest);

}

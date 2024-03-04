package com.movieplatform.channelservice.mapper;

import com.movieplatform.channelservice.dto.request.ChannelCreateRequest;
import com.movieplatform.channelservice.dto.response.ChannelResponseDto;
import com.movieplatform.channelservice.model.Channel;
import org.springframework.stereotype.Component;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Component
public class ChannelDtoMapper {

    public ChannelResponseDto convertEntityToDto(Channel channel){
        return ChannelResponseDto.builder()
                .name(channel.getName())
                .channelList(channel.getMovieList())
                .build();
    }

    public Channel convertCreateRequestToEntity(ChannelCreateRequest channelCreateRequest){
        return Channel.builder()
                .name(channelCreateRequest.getName())
                .movieList(channelCreateRequest.getMovieList())
                .channelDate(channelCreateRequest.getChannelDate())
                .build();
    }
}

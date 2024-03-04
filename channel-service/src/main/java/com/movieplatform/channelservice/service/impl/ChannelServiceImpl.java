package com.movieplatform.channelservice.service.impl;

import com.movieplatform.channelservice.client.MovieServiceClient;
import com.movieplatform.channelservice.constants.ExceptionMessages;
import com.movieplatform.channelservice.dto.request.ChannelCreateRequest;
import com.movieplatform.channelservice.dto.request.ChannelUpdateRequest;
import com.movieplatform.channelservice.dto.response.ChannelDto;
import com.movieplatform.channelservice.dto.response.ChannelResponseDto;
import com.movieplatform.channelservice.dto.response.MovieDto;
import com.movieplatform.channelservice.exception.ChannelNotFoundException;
import com.movieplatform.channelservice.mapper.ChannelDtoMapper;
import com.movieplatform.channelservice.model.Channel;
import com.movieplatform.channelservice.repository.ChannelRepository;
import com.movieplatform.channelservice.service.ChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Service
public class ChannelServiceImpl implements ChannelService {
    private static final Logger logger = LoggerFactory.getLogger(ChannelServiceImpl.class);

    private final ChannelRepository channelRepository;
    private final ChannelDtoMapper channelDtoMapper;
    private final MovieServiceClient movieServiceClient;

    public ChannelServiceImpl(ChannelRepository channelRepository, ChannelDtoMapper channelDtoMapper, MovieServiceClient movieServiceClient) {
        this.channelRepository = channelRepository;
        this.channelDtoMapper = channelDtoMapper;
        this.movieServiceClient = movieServiceClient;
    }

    @Override
    public List<ChannelResponseDto> findAll() {
        return channelRepository.findAll()
                .stream()
                .map(channel -> channelDtoMapper.convertEntityToDto(channel))
                .collect(Collectors.toList());
    }

    @Override
    public ChannelDto findAllMoviesInChannel(Long channelId) {
        Channel channel = channelRepository.findById(channelId)
                .orElseThrow(() -> new ChannelNotFoundException(channelId + ExceptionMessages.CHANNEL_SERVICE_NOT_FOUND));

        ChannelDto channelDto = new ChannelDto();
        channelDto.setId(channel.getId());
        channelDto.setName(channel.getName());
        //FeignClient will be used!!
        List<MovieDto> movieDtoList = channel.getMovieList().stream()
                .map((movie) -> {
                    MovieDto movieDto = movieServiceClient.findById(Long.valueOf(movie)).getBody();
                    return movieDto;
                }).collect(Collectors.toList());
        channelDto.setMovieDtoList(movieDtoList);
        return channelDto;
    }


    @Override
    public ChannelResponseDto findById(Long id) {
        Channel channel = channelRepository.findById(id)
                .orElseThrow(() -> new ChannelNotFoundException(id + ExceptionMessages.CHANNEL_SERVICE_NOT_FOUND));
        ChannelResponseDto channelResponseDto = channelDtoMapper.convertEntityToDto(channel);
        return channelResponseDto;
    }

    @Override
    public ChannelResponseDto createChannel(ChannelCreateRequest channelCreateRequest) {
        Channel channel = channelDtoMapper.convertCreateRequestToEntity(channelCreateRequest);
        Channel savedChannel = channelRepository.save(channel);
        return channelDtoMapper.convertEntityToDto(savedChannel);
    }

    @Override
    public ChannelResponseDto updateChannel(Long id, ChannelUpdateRequest channelUpdateRequest) {
        Channel toChannel = channelRepository.findById(id)
                .orElseThrow(() -> new ChannelNotFoundException(id + ExceptionMessages.CHANNEL_SERVICE_NOT_FOUND));
        toChannel.setName(channelUpdateRequest.getName());
        toChannel.setMovieList(channelUpdateRequest.getMovieList());

        Channel savedChannel = channelRepository.save(toChannel);
        return channelDtoMapper.convertEntityToDto(savedChannel);
    }
}

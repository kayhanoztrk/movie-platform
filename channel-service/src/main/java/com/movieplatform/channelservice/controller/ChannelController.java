package com.movieplatform.channelservice.controller;

import com.movieplatform.channelservice.dto.request.ChannelCreateRequest;
import com.movieplatform.channelservice.dto.response.ChannelDto;
import com.movieplatform.channelservice.dto.response.ChannelResponseDto;
import com.movieplatform.channelservice.service.ChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@RestController
@RequestMapping("/v1/channel")
public class ChannelController {

    private static final Logger logger = LoggerFactory.getLogger(ChannelController.class);
    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping
    public ResponseEntity<List<ChannelResponseDto>> findAll(){
        List<ChannelResponseDto> channelResponseDtoList = channelService.findAll();
        return ResponseEntity.ok(channelResponseDtoList);
    }

    @GetMapping("/id/{channelId}")
    public ResponseEntity<ChannelDto> findAllMoviesInChannel(Long channelId){
        ChannelDto channelDto = channelService.findAllMoviesInChannel(channelId);
        return ResponseEntity.ok(channelDto);
    }

    @PostMapping
    public ResponseEntity<ChannelResponseDto> createChannel(@RequestBody ChannelCreateRequest channelCreateRequest){
        ChannelResponseDto channelResponseDto = channelService.createChannel(channelCreateRequest);
        return ResponseEntity.ok(channelResponseDto);
    }

}

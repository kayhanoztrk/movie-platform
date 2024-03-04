package com.movieplatform.channelservice.exception;

import com.movieplatform.channelservice.model.Channel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ChannelNotFoundException extends RuntimeException {

    public ChannelNotFoundException(String message){
        super(message);
    }

    public ChannelNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
}

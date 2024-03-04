package com.movieplatform.userservice.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiException {
    private String message;
    private Throwable throwable;
    private ZonedDateTime zonedDateTime;
}

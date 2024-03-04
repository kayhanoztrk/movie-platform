package com.movieplatform.categoryservice.dto.request;

import lombok.Builder;
import lombok.Data;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Data
@Builder
public class CategoryCreateRequest {
    private String name;
}

package com.movieplatform.userservice.service;

import com.movieplatform.userservice.dto.UserCreateRequest;
import com.movieplatform.userservice.dto.UserDto;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface UserService {
    List<UserDto> findAll();
    UserDto findById(Long id);

    UserDto create(UserCreateRequest userCreateRequest);
}

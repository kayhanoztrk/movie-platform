package com.movieplatform.userservice.service.impl;

import com.movieplatform.userservice.constants.ExceptionMessages;
import com.movieplatform.userservice.dto.UserCreateRequest;
import com.movieplatform.userservice.dto.UserDto;
import com.movieplatform.userservice.exception.UserNotFoundException;
import com.movieplatform.userservice.mapper.UserDtoMapper;
import com.movieplatform.userservice.model.User;
import com.movieplatform.userservice.repository.UserRepository;
import com.movieplatform.userservice.service.UserService;
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
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    public UserServiceImpl(UserRepository userRepository, UserDtoMapper userDtoMapper) {
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(user -> userDtoMapper.convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        UserDto userDto = userRepository.findById(id)
                .map(user -> userDtoMapper.convertEntityToDto(user))
                .orElseThrow(() -> new UserNotFoundException(id + ExceptionMessages.USER_NOT_FOUND));
        return userDto;
    }

    @Override
    public UserDto create(UserCreateRequest userCreateRequest) {
        User user = userDtoMapper.convertCreateDtoToEntity(userCreateRequest);
        User savedUser = userRepository.save(user);
        return userDtoMapper.convertEntityToDto(savedUser);
    }
}

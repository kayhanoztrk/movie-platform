package com.movieplatform.userservice.mapper;

import com.movieplatform.userservice.dto.UserCreateRequest;
import com.movieplatform.userservice.dto.UserDto;
import com.movieplatform.userservice.model.User;
import org.springframework.stereotype.Component;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Component
public class UserDtoMapper {

    public User convertCreateDtoToEntity(UserCreateRequest userCreateRequest){
        return User.builder()
                .name(userCreateRequest.getName())
                .password(userCreateRequest.getPassword())
                .username(userCreateRequest.getUsername())
                .build();
    }

    public UserDto convertEntityToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .build();
    }
}

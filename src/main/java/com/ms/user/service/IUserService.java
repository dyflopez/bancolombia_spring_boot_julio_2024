package com.ms.user.service;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    ResponseEntity<UserEntity> save(UserDto userDto);

    ResponseEntity<UserEntity> getByEmail(String email);

}

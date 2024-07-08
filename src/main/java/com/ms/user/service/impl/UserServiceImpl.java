package com.ms.user.service.impl;

import com.ms.user.dto.UserDto;
import com.ms.user.exception.MyHandleException;
import com.ms.user.model.UserEntity;
import com.ms.user.repository.IUserRepository;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public ResponseEntity<UserEntity> save(UserDto userDto) {

        String uuid = UUID.randomUUID().toString();
        UserEntity user = UserEntity
                .builder()
                .id(uuid)
                .name(userDto.getName())
                .lastname(userDto.getLastname())
                .document(userDto.getDocument())
                .email(userDto.getEmail())
                .status(true)
                .build();

        var newUser =this.userRepository.save(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUser);
    }

    @Override
    public ResponseEntity<UserEntity> getByEmail(String email) {

        var userOpt =   this.userRepository.findByEmail(email);

        if(userOpt.isPresent()){
            return ResponseEntity.ok(userOpt.get());

        }

        throw new MyHandleException("no se encontro el usuario por el email");

    }
}

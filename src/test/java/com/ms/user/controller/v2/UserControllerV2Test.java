package com.ms.user.controller.v2;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import com.ms.user.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;



class UserControllerV2Test {


    @Mock
    private IUserService service;
    @InjectMocks
    private UserControllerV2 controller;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testCreateNewUser() {
        /**
         *  Crear la data
         */

        UserDto userDto = UserDto
                .builder()
                .email("daniel0223@hotmail.es")
                .name("daniel")
                .document("1030621323")
                .status(true)
                .lastname("florez")
                .build();

        var newUser = UserEntity
                .builder()
                .id("id")
                .email("daniel0223@hotmail.es")
                .name("daniel")
                .document("1030621323")
                .status(true)
                .lastname("florez")
                .build();

        var responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUser);
        /**
         *    crear el mock o la simulacion
         */

        when(service.save(userDto))
                .thenReturn(responseEntity);


        /**
         *  Ejecucion metodo
         */

        var result =   controller.create(userDto);


        var responseBody = result.getBody();

        /**
         * validacion
         */
        assertNotNull(responseBody);
        assertEquals(responseBody.getDocument(),"1030621323");
        assertEquals(result.getStatusCode(),HttpStatus.CREATED);
    }
}
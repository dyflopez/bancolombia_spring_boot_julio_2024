package com.ms.user.controller.v2.doc;


import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "user" , description = "API expuesta para la adminsitracion de usuario")
@RequestMapping("/api/v2/user")
public interface UserDocV2 {

    @Operation(summary = "create user")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "user created",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "internal server error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "endpoint not founded",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    )
            }
    )
    @PostMapping
    ResponseEntity<UserEntity> create(@RequestBody @Valid UserDto userDto);
}

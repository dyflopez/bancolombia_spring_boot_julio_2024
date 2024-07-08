package com.ms.user.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotBlank
    @NotEmpty
    @Size(min = 5 ,max = 12 ,message = "el tamaño minimo es 5 y el maximo 12")
    private String document;

    @NotBlank
    @NotEmpty
    private  String name;

    @NotBlank
    @NotEmpty
    private String lastname;

    private  boolean status;

    @NotBlank
    @Email
    private  String email;
}

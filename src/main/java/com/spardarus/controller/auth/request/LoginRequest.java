package com.spardarus.controller.auth.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class LoginRequest {

    @Email(message = "Incorrect email")
    @NotNull(message = "Please fill email")
    private String email;

    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@*#$%]).{8,20})",
            message = "Incorrect password")
    @NotNull(message = "Please fill password")
    private String password;
}

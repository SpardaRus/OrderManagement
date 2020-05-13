package com.spardarus.controller.auth.request;

import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import java.util.regex.Pattern;

@Data
public class LoginRequest {

    @Email(message = "Incorrect email")
    private String email;
    private String password;

    @AssertTrue(message = "Incorrect password")
    public boolean passwordIsValid() {
        String PASSWORD_PATTERN_REGEXP =
                "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@*#$%]).{8,20})";
        Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN_REGEXP);
//        return passwordPattern.matcher(password).matches();
        return false;
    }


}

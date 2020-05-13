package com.spardarus.service;

import com.spardarus.entity.UserSecurity;
import com.spardarus.repository.UserSecurityRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.regex.Pattern;

@Component
@AllArgsConstructor
public class AuthProvider implements AuthenticationProvider {

    private static final String PASSWORD_PATTERN_REGEXP =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@*#$%]).{8,20})";

    private final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN_REGEXP);
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserSecurityRepository userSecurityRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        if (!EmailValidator.getInstance().isValid(email)) {
            throw new BadCredentialsException("Incorrect email");
        }

        String password = (String) authentication.getCredentials();
        if (!passwordPattern.matcher(password).matches()) {
            throw new BadCredentialsException("Incorrect password");
        }

        UserSecurity user = userSecurityRepository.findByEmail(email);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            return new UsernamePasswordAuthenticationToken(user, password, authorities);
        } else
            throw new BadCredentialsException("Wrong email or password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}

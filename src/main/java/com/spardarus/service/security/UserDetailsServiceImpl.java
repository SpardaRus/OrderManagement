package com.spardarus.service.security;

import com.spardarus.entity.UserSecurity;
import com.spardarus.repository.UserSecurityRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserSecurityRepository userSecurityRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserSecurity user = userSecurityRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found with email : " + username);
        }

        return user;
    }
}

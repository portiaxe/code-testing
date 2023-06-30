package com.portiaxe.accounting.provider;

import com.portiaxe.accounting.dao.entity.AccountUser;
import com.portiaxe.accounting.dao.repo.AccountUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    private AccountUserRepository accountUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        AccountUser user = accountUserRepository.findByUsername(username);

        if (user == null || !user.getUsername().equalsIgnoreCase(username)) {
            throw new BadCredentialsException("Username not found.");
        }

        if(passwordEncoder.matches(password, user.getPassword())){
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("USER");
            authorities.add(simpleGrantedAuthority);

            return new UsernamePasswordAuthenticationToken(user, password, authorities);
        }

        throw new BadCredentialsException("Wrong password.");
    }

}

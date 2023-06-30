package com.portiaxe.accounting.service;

import com.portiaxe.accounting.dao.entity.AccountUser;
import com.portiaxe.accounting.dao.repo.AccountUserRepository;
import com.portiaxe.accounting.dto.AccountUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountUserService implements UserDetailsService {

    @Autowired
    private AccountUserRepository accountUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountUser accountUser = accountUserRepository.findByUsername(username);

        if(accountUser != null){
            return new AccountUserDetails(accountUser);
        }

        return null;
    }
}

package com.spriti.Banking_App.service;

import com.spriti.Banking_App.entity.Account;
import com.spriti.Banking_App.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Account> opt = accRepo.findByEmail(username);

        if(opt.isPresent()) {
            Account account = opt.get();

            List<GrantedAuthority> authorities = new ArrayList<>();
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority(account.getRole());
            authorities.add(sga);

            User user = new User(account.getName(), account.getPassword(), authorities);

            return user;
        }else{
            throw new RuntimeException("Account Not Found CUDS");
        }
    }
}

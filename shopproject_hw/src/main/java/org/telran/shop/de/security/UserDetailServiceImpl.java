package org.telran.shop.de.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.telran.shop.de.entity.User;
import org.telran.shop.de.service.UserService;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User login = service.getByLogin(username);
        if (login == null) {
            throw new UsernameNotFoundException("User with login " + username + " not found");
        }
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
                login.getLogin(),
                login.getPassword(),
                List.of(new SimpleGrantedAuthority("USER"))
        );
        return user;
    }
}

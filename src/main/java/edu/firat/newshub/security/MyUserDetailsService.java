package edu.firat.newshub.security;

import edu.firat.newshub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    edu.firat.newshub.model.User fetchedUser;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<SimpleGrantedAuthority> roles = null;
        fetchedUser = userService.getUserByUsername(username);
        roles = Arrays.asList(new SimpleGrantedAuthority(fetchedUser.getRole()));
        User user = new User(username, fetchedUser.getPassword(), roles);
        return user;
    }

}
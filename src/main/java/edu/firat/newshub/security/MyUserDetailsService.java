package edu.firat.newshub.security;

import edu.firat.newshub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    edu.firat.newshub.model.User fetchedUser;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        fetchedUser = userService.getUserByUsername(username);
        User user = new User(username, fetchedUser.getPassword(), new ArrayList<>());
        return user;
    }

}
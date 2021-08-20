package edu.firat.newshub.controller;


import edu.firat.newshub.model.User;
import edu.firat.newshub.security.JwtUtil;
import edu.firat.newshub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public User getOwnData(@RequestHeader("Authorization") String authorizationHeader) {
        return userService.getUserByUsername(getUsername(authorizationHeader));
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return createdUser;
    }


    @PutMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public User updateUser(@RequestHeader("Authorization") String authorizationHeader, @RequestBody User user) {
        String username = getUsername(authorizationHeader);
        user.setUsername(username);
        return userService.updateUser(user);
    }

    @DeleteMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public Boolean deleteUser(@RequestHeader("Authorization") String authorizationHeader) {
        String username = getUsername(authorizationHeader);
        return userService.deleteUser(username);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAll(){
        return userService.getAllUserData();
    }


    public String getUsername(String authorizationHeader) {
        return jwtUtil.extractUsername(authorizationHeader.substring(7));
    }


}

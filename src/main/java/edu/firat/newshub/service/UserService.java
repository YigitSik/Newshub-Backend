package edu.firat.newshub.service;

import edu.firat.newshub.model.User;
import edu.firat.newshub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserService(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder=passwordEncoder;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        String rawPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
        user.setRole("USER");
        return userRepository.save(user);
    }

    public List<User> getAllUserData(){
        return userRepository.findAllByRoleEquals("USER");
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public Boolean deleteUser(String username) {
        System.out.println(username);
        User u = userRepository.findByUsername(username);
        Long userId = u.getUserId();
        Boolean response = Boolean.FALSE;
        try {
            userRepository.deleteById(userId);
            response = Boolean.TRUE;
        } catch (Exception e) {

        }
        return response;
    }


}

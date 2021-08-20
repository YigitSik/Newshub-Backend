package edu.firat.newshub.repository;

import edu.firat.newshub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    List<User> findAllByRoleEquals(String role);
}

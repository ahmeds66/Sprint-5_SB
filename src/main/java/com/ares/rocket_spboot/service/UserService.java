package com.ares.rocket_spboot.service;

import com.ares.rocket_spboot.entities.Roles;
import com.ares.rocket_spboot.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);


    Roles addRole(Roles role);

    User addRoleToUser(String username, String role);

    List<User> findAllUsers();
}

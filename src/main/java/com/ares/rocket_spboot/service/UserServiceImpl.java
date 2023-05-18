package com.ares.rocket_spboot.service;

import com.ares.rocket_spboot.entities.User;
import com.ares.rocket_spboot.repos.RoleRepository;
import com.ares.rocket_spboot.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ares.rocket_spboot.entities.Roles;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Roles addRole(Roles role) {
        return roleRepository.save(role);
    }


    @Override
    public User addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Roles r = roleRepository.findByRole(roleName);
        user.getRoles().add(r);
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


}

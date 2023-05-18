package com.ares.rocket_spboot;

import com.ares.rocket_spboot.entities.Agence;
import com.ares.rocket_spboot.entities.Rocket;
import com.ares.rocket_spboot.entities.User;
import com.ares.rocket_spboot.service.RocketService;
import com.ares.rocket_spboot.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import com.ares.rocket_spboot.entities.Roles;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class RocketSpBootApplication implements CommandLineRunner {
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(RocketSpBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Rocket.class, Agence.class);
    }

    /*@PostConstruct
    void init_users(){
        //Add roles
        userService.addRole(new Roles(null, "USER"));
        userService.addRole(new Roles(null, "ADMIN"));

        //Add users
        userService.saveUser(new User(null,"Admin","1234",true,null));
        userService.saveUser(new User(null,"User","1234",true,null));
        userService.saveUser(new User(null,"Ahmed","1234",true,null));

        //Add roles to users
        userService.addRoleToUser("Admin", "ADMIN");
        userService.addRoleToUser("Ahmed", "USER");
        userService.addRoleToUser("User", "USER");
    }*/

    @Bean
    BCryptPasswordEncoder getBCE(){
        return new BCryptPasswordEncoder();
    }
}

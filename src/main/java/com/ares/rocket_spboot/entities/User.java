package com.ares.rocket_spboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.ares.rocket_spboot.entities.Roles;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(unique = true)
    private String username;
    private String password;
    private Boolean enabled;

        @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "USERS_ROLES", joinColumns = @JoinColumn(name = "idUser") ,
            inverseJoinColumns =  @JoinColumn(name = "role_id"))
    private List<Roles> roles;
}

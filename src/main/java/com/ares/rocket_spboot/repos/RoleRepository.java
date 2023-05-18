package com.ares.rocket_spboot.repos;

import com.ares.rocket_spboot.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByRole(String role);
}

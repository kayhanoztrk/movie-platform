package com.movieplatform.userservice.repository;

import com.movieplatform.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}

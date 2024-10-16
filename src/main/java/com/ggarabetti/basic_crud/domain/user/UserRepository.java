package com.ggarabetti.basic_crud.domain.user;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByLogin(String login);
}

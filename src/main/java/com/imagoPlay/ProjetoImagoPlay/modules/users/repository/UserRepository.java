package com.imagoPlay.ProjetoImagoPlay.modules.users.repository;
import com.imagoPlay.ProjetoImagoPlay.modules.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository <User, UUID> {
    Optional<User> findByEmail(String email);
}

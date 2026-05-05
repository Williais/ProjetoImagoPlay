package com.imagoPlay.ProjetoImagoPlay.modules.producer.repository;

import com.imagoPlay.ProjetoImagoPlay.modules.producer.entity.Producer;
import com.imagoPlay.ProjetoImagoPlay.modules.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProducerRepository extends JpaRepository<Producer, UUID> {
    boolean existsByUser(User user);
}

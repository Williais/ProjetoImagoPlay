package com.imagoPlay.ProjetoImagoPlay.modules.producer.repository;

import com.imagoPlay.ProjetoImagoPlay.modules.producer.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProducerRepository extends JpaRepository<Producer, UUID> {

}

package com.imagoPlay.ProjetoImagoPlay.modules.video.repository;

import com.imagoPlay.ProjetoImagoPlay.modules.video.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, UUID> {

}

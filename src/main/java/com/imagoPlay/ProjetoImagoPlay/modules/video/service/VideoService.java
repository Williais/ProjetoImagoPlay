package com.imagoPlay.ProjetoImagoPlay.modules.video.service;

import com.imagoPlay.ProjetoImagoPlay.modules.video.entity.Video;
import com.imagoPlay.ProjetoImagoPlay.modules.video.repository.VideoRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository){
        this.videoRepository = videoRepository;
    }
}

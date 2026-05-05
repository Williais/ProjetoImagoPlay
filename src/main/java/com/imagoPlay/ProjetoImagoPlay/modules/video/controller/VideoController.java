package com.imagoPlay.ProjetoImagoPlay.modules.video.controller;

import com.imagoPlay.ProjetoImagoPlay.modules.video.service.VideoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
public class VideoController {
    private final VideoService videoService;

    public VideoController(VideoService service){
        this.videoService = service;
    }
}

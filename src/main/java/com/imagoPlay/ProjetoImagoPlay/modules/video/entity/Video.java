package com.imagoPlay.ProjetoImagoPlay.modules.video.entity;

import com.imagoPlay.ProjetoImagoPlay.modules.video.enums.VideoGenero;
import com.imagoPlay.ProjetoImagoPlay.modules.video.enums.VideoStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_video")
@Getter
@Setter
public class Video {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String titulo;
    private String sinopse;
    private VideoGenero genero;
    private String thumbnailUrl;
    private float duracao;
    private boolean possuiLegenda;
    private boolean possuiAudioDescricao;

    private String videoUrl;
    private VideoStatus status;
    private boolean isOriginal;

}

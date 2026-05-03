package com.imagoPlay.ProjetoImagoPlay.modules.video.dto;

import com.imagoPlay.ProjetoImagoPlay.modules.video.enums.VideoGenero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoRequestDTO {
    private String titulo;
    private String sinopse;
    private VideoGenero genero;
    private String thumbnailUrl;
    private float duracao;
    private boolean possuiLegenda;
    private boolean possuiAudioDescricao;
}

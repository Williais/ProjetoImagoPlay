package com.imagoPlay.ProjetoImagoPlay.modules.video.dto;


import com.imagoPlay.ProjetoImagoPlay.modules.video.enums.VideoGenero;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class VideoResponseDTO {
    private UUID id;
    private String titulo;
    private String sinopse;
    private VideoGenero genero;
    private float duracao;
    private boolean possuiLegenda;
    private boolean possuiAudioDescricao;
}

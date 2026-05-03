package com.imagoPlay.ProjetoImagoPlay.modules.producer.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class ProducerResponseDTO {
    private UUID id;
    private String cpfCnpj;
    private String bio;
    private String cidade;
    private String estado;
    private String nomeArtistico;
    private String chavePix;
}

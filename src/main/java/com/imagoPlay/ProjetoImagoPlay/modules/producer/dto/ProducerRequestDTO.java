package com.imagoPlay.ProjetoImagoPlay.modules.producer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProducerRequestDTO {
    private String cpfCnpj;
    private String bio;
    private String cidade;
    private String estado;
    private String nomeArtistico;
}

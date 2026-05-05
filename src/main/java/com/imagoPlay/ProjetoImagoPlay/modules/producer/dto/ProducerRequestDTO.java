package com.imagoPlay.ProjetoImagoPlay.modules.producer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProducerRequestDTO {

    @NotBlank(message = "O CPF é obrigatório")
    @Size(min = 11, max = 18, message = "Tamanho de documento inválido")
    private String cpfCnpj;

    @NotBlank(message = "A Bio é obrigatório")
    private String bio;
    @NotBlank(message = "A Cidade é obrigatório")
    private String cidade;
    @NotBlank(message = "O Estado é obrigatório")
    private String estado;
    @NotBlank(message = "O Nome é obrigatório")
    private String nomeArtistico;

    @NotBlank(message = "A chave é obrigatório")
    private String chavePix;
}

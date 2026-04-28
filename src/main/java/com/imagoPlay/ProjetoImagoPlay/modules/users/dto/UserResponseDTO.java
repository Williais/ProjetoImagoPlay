package com.imagoPlay.ProjetoImagoPlay.modules.users.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserResponseDTO {// O Filtro de Saída(Devolve para o React)

    private UUID id;
    private String nome;
    private String email;
}

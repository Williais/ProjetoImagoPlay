package com.imagoPlay.ProjetoImagoPlay.modules.users.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserResponseDTO {

    private UUID id;
    private String nome;
    private String email;
}

package com.imagoPlay.ProjetoImagoPlay.modules.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO { // Dados que vem do meu Front (O Filtro de Entrada)
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatório")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String senha;
}

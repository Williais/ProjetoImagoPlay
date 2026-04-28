package com.imagoPlay.ProjetoImagoPlay.modules.producer.entity;

import com.imagoPlay.ProjetoImagoPlay.modules.users.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_producer")
@Getter
@Setter
public class Producer {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private User userID; // nao sei fazer esse relacionamento aq...

    private String cpfCnpj; //criar uma validação depois
    private String bio;
    private String cidade;
    private String estado;
    private String nomeArtistico;

    private boolean aprovado;
}

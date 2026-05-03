package com.imagoPlay.ProjetoImagoPlay.modules.producer.entity;

import com.imagoPlay.ProjetoImagoPlay.modules.users.entity.User;
import jakarta.persistence.*;
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

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    private String cpfCnpj;
    private String bio;
    private String cidade;
    private String estado;
    private String nomeArtistico;

    private String chavePix;

    private boolean isAprovado = false;
}

package com.imagoPlay.ProjetoImagoPlay.modules.users.entity;
import java.time.LocalDateTime;
import java.util.UUID;

import com.imagoPlay.ProjetoImagoPlay.modules.users.enums.UserPlano;
import com.imagoPlay.ProjetoImagoPlay.modules.users.enums.UserRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Enumerated(EnumType.STRING)
    private UserPlano plano;
    @CreationTimestamp
    private LocalDateTime createdAt;

}

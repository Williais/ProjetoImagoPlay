package com.imagoPlay.ProjetoImagoPlay.modules.users.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.imagoPlay.ProjetoImagoPlay.modules.users.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public Instant gerarDataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String gerarToken(User user){
        try{
            Algorithm chave = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("ImagoPlay")
                    .withSubject(user.getEmail())
                    .withClaim("role", user.getRole().name())
                    .withExpiresAt(gerarDataExpiracao())
                    .sign(chave);

        }catch(JWTCreationException error){
            throw new JWTCreationException("Ocorreu um error", error);

        }

    }

    public String validarToken(String token){
        try{
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("ImagoPlay")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch(JWTCreationException error){
            return "";
        }
    }
}

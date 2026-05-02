package com.imagoPlay.ProjetoImagoPlay.modules.users.service;

import com.imagoPlay.ProjetoImagoPlay.modules.users.dto.LoginRequestDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.users.dto.LoginResponseDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.users.dto.UserRequestDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.users.dto.UserResponseDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.users.entity.User;
import com.imagoPlay.ProjetoImagoPlay.modules.users.enums.UserPlano;
import com.imagoPlay.ProjetoImagoPlay.modules.users.enums.UserRole;
import com.imagoPlay.ProjetoImagoPlay.modules.users.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenService tokenService;

    public UserService(UserRepository u, BCryptPasswordEncoder bCrypt, TokenService t){
        this.tokenService = t;
        this.userRepository = u;
        this.bCryptPasswordEncoder = bCrypt;
    }

    public UserResponseDTO cadastrarUsuario(UserRequestDTO request){

        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Este E-mail já está em uso!");
        }

        User newUser = new User();
        newUser.setNome(request.getNome());
        newUser.setEmail(request.getEmail());
        newUser.setSenha(bCryptPasswordEncoder.encode(request.getSenha()));
        newUser.setRole(UserRole.USER);
        newUser.setPlano(UserPlano.FREE);

        User usuarioSalvo = userRepository.save(newUser);

        UserResponseDTO response = new UserResponseDTO();
        response.setEmail(usuarioSalvo.getEmail());
        response.setNome(usuarioSalvo.getNome());
        response.setId(usuarioSalvo.getId());

        return response;
    }

    public LoginResponseDTO autenticarUsuario(LoginRequestDTO login){
        User usuarioEncontrado = userRepository.
                findByEmail(login.getEmail()).
                orElseThrow(() -> new RuntimeException("E-mail ou senha incorretos"));

        String senha = login.getSenha();
        String hashSenha = usuarioEncontrado.getSenha();

        if(!bCryptPasswordEncoder.matches(senha, hashSenha)){
            throw new RuntimeException("E-mail ou senha incorretos");
        }else {

            String token = tokenService.gerarToken(usuarioEncontrado);

            LoginResponseDTO validacao = new LoginResponseDTO();

            validacao.setNome(usuarioEncontrado.getNome());
            validacao.setToken(token);

            return validacao;
        }


    }
}

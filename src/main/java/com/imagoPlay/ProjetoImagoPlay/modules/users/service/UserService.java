package com.imagoPlay.ProjetoImagoPlay.modules.users.service;

import com.imagoPlay.ProjetoImagoPlay.modules.users.dto.LoginRequestDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.users.dto.UserRequestDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.users.dto.UserResponseDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.users.entity.User;
import com.imagoPlay.ProjetoImagoPlay.modules.users.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository u, BCryptPasswordEncoder bCrypt){

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

        User usuarioSalvo = userRepository.save(newUser);

        UserResponseDTO response = new UserResponseDTO();
        response.setEmail(usuarioSalvo.getEmail());
        response.setNome(usuarioSalvo.getNome());
        response.setId(usuarioSalvo.getId());

        return response;
    }

    public UserResponseDTO autenticarUsuario(LoginRequestDTO login){
        User usuarioEncontrado = userRepository.
                findByEmail(login.getEmail()).
                orElseThrow(() -> new RuntimeException("E-mail ou senha incorretos"));

        String senha = login.getSenha();
        String hashSenha = usuarioEncontrado.getSenha();

        if(!bCryptPasswordEncoder.matches(senha, hashSenha)){
            throw new RuntimeException("E-mail ou senha incorretos");
        }else {
            UserResponseDTO usuario =new UserResponseDTO();

            usuario.setNome(usuarioEncontrado.getNome());
            usuario.setId(usuarioEncontrado.getId());
            usuario.setEmail(usuarioEncontrado.getEmail());

            return usuario;
        }


    }
}

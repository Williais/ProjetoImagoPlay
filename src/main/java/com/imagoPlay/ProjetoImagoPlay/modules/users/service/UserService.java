package com.imagoPlay.ProjetoImagoPlay.modules.users.service;

import com.imagoPlay.ProjetoImagoPlay.modules.users.dto.UserRequestDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.users.dto.UserResponseDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.users.entity.User;
import com.imagoPlay.ProjetoImagoPlay.modules.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository u){
        this.userRepository = u;
    }

    public UserResponseDTO cadastrarUsuario(UserRequestDTO request){

        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Este E-mail já está em uso!");
        }

        User newUser = new User();
        newUser.setNome(request.getNome());
        newUser.setEmail(request.getEmail());
        newUser.setSenha(request.getSenha());

        User usuarioSalvo = userRepository.save(newUser);

        UserResponseDTO response = new UserResponseDTO();
        response.setEmail(usuarioSalvo.getEmail());
        response.setNome(usuarioSalvo.getNome());
        response.setId(usuarioSalvo.getId());

        return response;
    }
}

package com.imagoPlay.ProjetoImagoPlay.modules.users.controller;

import com.imagoPlay.ProjetoImagoPlay.modules.users.dto.UserRequestDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.users.dto.UserResponseDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.users.entity.User;
import com.imagoPlay.ProjetoImagoPlay.modules.users.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService service){
        this.userService = service;
    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO u){
        return userService.cadastrarUsuario(u);
    }
}

package com.imagoPlay.ProjetoImagoPlay.modules.producer.service;

import com.imagoPlay.ProjetoImagoPlay.config.SecurityConfig;
import com.imagoPlay.ProjetoImagoPlay.modules.producer.dto.ProducerRequestDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.producer.dto.ProducerResponseDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.producer.entity.Producer;
import com.imagoPlay.ProjetoImagoPlay.modules.producer.repository.ProducerRepository;
import com.imagoPlay.ProjetoImagoPlay.modules.users.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private final ProducerRepository producerRepository;

    public ProducerService(ProducerRepository pr){
        this.producerRepository = pr;
    }

    public ProducerResponseDTO solicitarPerfil(ProducerRequestDTO p){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        User userLogado = (User) authentication.getPrincipal();

        if(producerRepository.existsByUser(userLogado)){
            throw new RuntimeException("Usuário já possui um perfil de produtor.");
        }

        Producer produtor = new Producer();

        produtor.setBio(p.getBio());
        produtor.setCidade(p.getCidade());
        produtor.setNomeArtistico(p.getNomeArtistico());
        produtor.setEstado(p.getEstado());
        produtor.setCpfCnpj(p.getCpfCnpj());
        produtor.setChavePix(p.getChavePix());
        produtor.setUser(userLogado);

        Producer produtorSalvo = producerRepository.save(produtor);

        ProducerResponseDTO response = new ProducerResponseDTO();

        response.setBio(produtorSalvo.getBio());
        response.setCidade(produtorSalvo.getCidade());
        response.setId(produtorSalvo.getId());
        response.setChavePix(produtorSalvo.getChavePix());
        response.setCpfCnpj(produtorSalvo.getCpfCnpj());
        response.setEstado(produtorSalvo.getEstado());
        response.setNomeArtistico(produtorSalvo.getNomeArtistico());

        return response;
    }

    public void validarCpfCnpj(Producer cpfCnpj){

    }

}

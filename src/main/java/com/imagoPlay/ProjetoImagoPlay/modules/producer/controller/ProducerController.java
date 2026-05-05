package com.imagoPlay.ProjetoImagoPlay.modules.producer.controller;

import com.imagoPlay.ProjetoImagoPlay.modules.producer.dto.ProducerRequestDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.producer.dto.ProducerResponseDTO;
import com.imagoPlay.ProjetoImagoPlay.modules.producer.service.ProducerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService service){
        this.producerService = service;
    }

    @PostMapping
    public ResponseEntity<ProducerResponseDTO> createProducer(@Valid @RequestBody ProducerRequestDTO requestDTO){

        return ResponseEntity.status(201).body(producerService.solicitarPerfil(requestDTO));
    }
}

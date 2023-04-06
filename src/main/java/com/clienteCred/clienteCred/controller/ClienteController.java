package com.clienteCred.clienteCred.controller;

import com.clienteCred.clienteCred.DTO.ClienteDTO;
import com.clienteCred.clienteCred.model.ClienteModel;
import com.clienteCred.clienteCred.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@Valid @RequestBody ClienteDTO dto) {
        ClienteModel clienteCriado = clienteRepository.save(dto.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado.toDto());
    }



    /*

    FALTA CAMADA SERVICE

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> buscarClientePorCpf(@PathVariable String cpf) {
        ClienteDTO dto = clienteService.buscarClientePorCpf(cpf);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    */

}

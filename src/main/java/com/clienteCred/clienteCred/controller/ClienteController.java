package com.clienteCred.clienteCred.controller;

import com.clienteCred.clienteCred.DTO.ClienteDTO;
import com.clienteCred.clienteCred.model.ClienteModel;
import com.clienteCred.clienteCred.repository.ClienteRepository;
import com.clienteCred.clienteCred.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@Valid @RequestBody ClienteDTO dto) {
        ClienteModel clienteCriado = clienteRepository.save(dto.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado.toDto());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> buscarClientePorCpf(@PathVariable String cpf) {
        Optional<ClienteModel> clienteOpcional = clienteService.buscarClientePorCpf(cpf);
        if (clienteOpcional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            ClienteModel cliente = clienteOpcional.get();
            return ResponseEntity.ok(cliente.toDto());
        }
    }

}

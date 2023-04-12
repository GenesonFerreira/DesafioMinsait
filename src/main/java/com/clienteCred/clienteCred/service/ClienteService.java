package com.clienteCred.clienteCred.service;

import com.clienteCred.clienteCred.DTO.ClienteDTO;
import com.clienteCred.clienteCred.model.ClienteModel;
import com.clienteCred.clienteCred.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<ClienteModel> buscarClientePorCpf(String cpf){
        Optional<ClienteModel> cliente = clienteRepository.findById(cpf);
        return cliente;
    }

}

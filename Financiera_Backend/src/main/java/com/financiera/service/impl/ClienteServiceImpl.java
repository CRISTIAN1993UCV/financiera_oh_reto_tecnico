package com.financiera.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financiera.model.dto.ClientesListDto;
import com.financiera.model.entity.Cliente;
import com.financiera.repository.ClienteRepository;
import com.financiera.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClientesListDto getAllClientes() {

        ClientesListDto clienteListDto = new ClientesListDto();
        clienteListDto.setClientes(clienteRepository.findAll());
        return clienteListDto;
    }

    @Override
    public Optional<Cliente> getClienteById(Long id) {

        return clienteRepository.findById(id);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente updatedCliente) {

        // Cliente clienteDB=clienteRepository.getById(id);
        updatedCliente.setId(id);
        return clienteRepository.save(updatedCliente);
    }

    @Override
    public void deleteCliente(Long id) {

        clienteRepository.deleteById(id);
    }

   
}

package com.financiera.service;

import java.util.List;
import java.util.Optional;

import com.financiera.model.dto.ClientesListDto;
import com.financiera.model.entity.Cliente;

public interface ClienteService {
    ClientesListDto getAllClientes();
    
    Optional<Cliente>  getClienteById(Long id);

    Cliente createCliente(Cliente cliente);

    Cliente updateCliente(Long id, Cliente updatedCliente);

    void deleteCliente(Long id);
}
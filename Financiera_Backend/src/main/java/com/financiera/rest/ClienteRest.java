package com.financiera.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financiera.model.dto.ResponseEntityDto;
import com.financiera.model.entity.Cliente;
import com.financiera.service.ClienteService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/clientes")
public class ClienteRest {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntityDto getAllClientes() {
        System.out.println(clienteService.getAllClientes().getClientes().size());
        return ResponseEntityDto.builder()._embedded(clienteService.getAllClientes()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntityDto getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        
        return ResponseEntityDto.builder()._embedded(cliente.get()).build();
    }

    @PostMapping
    public ResponseEntityDto createCliente(@RequestBody Cliente cliente) {
        cliente= clienteService.createCliente(cliente);
        return ResponseEntityDto.builder()._embedded(cliente).build();
    }

    @PutMapping("/{id}")
    public ResponseEntityDto updateCliente(@PathVariable Long id, @RequestBody Cliente updatedCliente) {
        updatedCliente= clienteService.updateCliente(id,updatedCliente);
        return ResponseEntityDto.builder()._embedded(updatedCliente).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntityDto deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntityDto.builder()._embedded(null).build();
    }
}

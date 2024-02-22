package com.financiera.model.dto;

import java.util.List;

import com.financiera.model.entity.Cliente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientesListDto {
    List<Cliente> clientes;
}

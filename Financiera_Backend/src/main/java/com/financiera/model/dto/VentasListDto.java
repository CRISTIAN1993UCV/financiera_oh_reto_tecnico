package com.financiera.model.dto;

import java.util.List;

import com.financiera.model.entity.Venta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentasListDto {
    List<Venta> ventas;
}

package com.financiera.model.dto;

import java.util.List;

import com.financiera.model.entity.DetalleVenta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleVentasListDto {
    List<DetalleVenta> detalleVentas;
}

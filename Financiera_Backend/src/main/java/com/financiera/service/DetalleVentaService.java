package com.financiera.service;

import java.util.List;
import java.util.Optional;

import com.financiera.model.dto.DetalleVentasListDto;
import com.financiera.model.entity.DetalleVenta;
import com.financiera.model.entity.FullDetalleVenta;


public interface DetalleVentaService {
    DetalleVentasListDto getAllDetalleVentas();
    
    Optional<DetalleVenta>  getDetalleVentaById(Long id);

    DetalleVenta createDetalleVenta(DetalleVenta detalleVenta);

    DetalleVenta updateDetalleVenta(Long id, DetalleVenta updatedDetalleVenta);

    void deleteDetalleVenta(Long id);

    List<FullDetalleVenta> getFullDetalleVentas(Long id);
}
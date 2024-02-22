package com.financiera.service;

import java.util.List;
import java.util.Optional;

import com.financiera.model.dto.VentasListDto;
import com.financiera.model.entity.FullDetailVenta;
import com.financiera.model.entity.Venta;

public interface VentaService {
    VentasListDto getAllVentas();
    
    Optional<Venta> getVentaById(Long id);

    Venta createVenta(Venta venta);

    Venta updateVenta(Long id, Venta updatedVenta);

    void deleteVenta(Long id);

    List<FullDetailVenta> getFullDetailVentas(String filterDate);
}
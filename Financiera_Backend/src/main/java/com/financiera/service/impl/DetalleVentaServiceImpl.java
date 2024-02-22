package com.financiera.service.impl;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financiera.model.dto.DetalleVentasListDto;
import com.financiera.model.entity.DetalleVenta;
import com.financiera.model.entity.FullDetailVenta;
import com.financiera.model.entity.FullDetalleVenta;
import com.financiera.repository.DetalleVentaRepository;
import com.financiera.service.DetalleVentaService;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public DetalleVentasListDto getAllDetalleVentas() {

        DetalleVentasListDto detalleVentaListDto = new DetalleVentasListDto();
        detalleVentaListDto.setDetalleVentas(detalleVentaRepository.findAll());
        return detalleVentaListDto;
    }

    @Override
    public Optional<DetalleVenta> getDetalleVentaById(Long id) {

        return detalleVentaRepository.findById(id);
    }

    @Override
    public DetalleVenta createDetalleVenta(DetalleVenta detalleVenta) {

        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta updateDetalleVenta(Long id, DetalleVenta updatedDetalleVenta) {

        // DetalleVenta DetalleVentaDB=detalleVentaRepository.getById(id);
        updatedDetalleVenta.setId(id);
        return detalleVentaRepository.save(updatedDetalleVenta);
    }

    @Override
    public void deleteDetalleVenta(Long id) {

        detalleVentaRepository.deleteById(id);
    }


    @Override
    public List<FullDetalleVenta> getFullDetalleVentas(Long id) {
        return detalleVentaRepository.findDetalleVentaByIdVenta(id);
    }
   
}

package com.financiera.service.impl;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financiera.model.dto.VentasListDto;
import com.financiera.model.entity.FullDetailVenta;
import com.financiera.model.entity.Venta;
import com.financiera.repository.VentaRepository;
import com.financiera.service.VentaService;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;


@Service
public class VentaServiceImpl implements VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public VentasListDto getAllVentas() {

        VentasListDto ventasListDto = new VentasListDto();
        ventasListDto.setVentas(ventaRepository.findAll());
        return ventasListDto;
    }

    @Override
    public Optional<Venta> getVentaById(Long id) {

        return ventaRepository.findById(id);
    }

    @Override
    public Venta createVenta(Venta venta) {

        return ventaRepository.save(venta);
    }

    @Override
    public Venta updateVenta(Long id, Venta updatedVenta) {

        // Venta VentaDB=ventaRepository.getById(id);
        updatedVenta.setId(id);
        return ventaRepository.save(updatedVenta);
    }

    @Override
    public void deleteVenta(Long id) {

        ventaRepository.deleteById(id);
    }

    @Override
    public List<FullDetailVenta> getFullDetailVentas(String filterDate) {
        List<FullDetailVenta> fullDetailVentaList = new ArrayList<>();
        List<FullDetailVenta> result = ventaRepository.findFullList();

        if (!filterDate.isEmpty()) {
            result = ventaRepository.findFullListFilter(filterDate);
        }

        result.forEach(row -> {
            FullDetailVenta fullDetailVenta = new FullDetailVenta();
            fullDetailVenta.setId(row.getId());
            fullDetailVenta.setId_cliente(row.getId_cliente());;
            fullDetailVenta.setNombres(row.getNombres());
            fullDetailVenta.setApellidos(row.getApellidos());
            fullDetailVenta.setFecha(row.getFecha());
            fullDetailVenta.setTotal(row.getTotal());
            fullDetailVentaList.add(fullDetailVenta);
        });
        return fullDetailVentaList;
    }


   
}

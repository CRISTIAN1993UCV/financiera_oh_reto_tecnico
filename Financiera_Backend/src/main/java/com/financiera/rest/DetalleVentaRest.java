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
import com.financiera.model.entity.DetalleVenta;
import com.financiera.service.DetalleVentaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/DetalleVentas")
public class DetalleVentaRest {
    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public ResponseEntityDto getAllDetalleVentas() {
        System.out.println(detalleVentaService.getAllDetalleVentas().getDetalleVentas().size());
        return ResponseEntityDto.builder()._embedded(detalleVentaService.getAllDetalleVentas()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntityDto getDetalleVentaById(@PathVariable Long id) {
        Optional<DetalleVenta> detalleVenta = detalleVentaService.getDetalleVentaById(id);
        
        return ResponseEntityDto.builder()._embedded(detalleVenta.get()).build();
    }

    @GetMapping("/full-detalle-venta/{id}")
    public ResponseEntityDto getFullDetalleVentas(@PathVariable Long id) {        
        return ResponseEntityDto.builder()._embedded(detalleVentaService.getFullDetalleVentas(id)).build();
    }

    @PostMapping
    public ResponseEntityDto createDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        detalleVenta= detalleVentaService.createDetalleVenta(detalleVenta);
        return ResponseEntityDto.builder()._embedded(detalleVenta).build();
    }

    @PutMapping("/{id}")
    public ResponseEntityDto updateStudent(@PathVariable Long id, @RequestBody DetalleVenta updatedDetalleVenta) {
        updatedDetalleVenta= detalleVentaService.updateDetalleVenta(id,updatedDetalleVenta);
        return ResponseEntityDto.builder()._embedded(updatedDetalleVenta).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntityDto deleteStudent(@PathVariable Long id) {
        detalleVentaService.deleteDetalleVenta(id);
        return ResponseEntityDto.builder()._embedded(null).build();
    }
}

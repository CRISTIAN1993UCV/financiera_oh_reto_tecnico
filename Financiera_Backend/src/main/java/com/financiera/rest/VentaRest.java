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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.financiera.model.dto.ResponseEntityDto;
import com.financiera.model.entity.Venta;
import com.financiera.service.VentaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ventas")
public class VentaRest {
    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntityDto getAllVentas() {
        System.out.println(ventaService.getAllVentas().getVentas().size());
        return ResponseEntityDto.builder()._embedded(ventaService.getAllVentas()).build();
    }

    @GetMapping("/detail")
    public ResponseEntityDto getFullDetailVentas(@RequestParam(name = "filterDate", required = false) String filterDate) {
        return ResponseEntityDto.builder()._embedded(ventaService.getFullDetailVentas(filterDate)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntityDto getVentaById(@PathVariable Long id) {
        Optional<Venta> venta = ventaService.getVentaById(id);
        
        return ResponseEntityDto.builder()._embedded(venta.get()).build();
    }

    @PostMapping
    public ResponseEntityDto createVenta(@RequestBody Venta venta) {
        venta= ventaService.createVenta(venta);
        return ResponseEntityDto.builder()._embedded(venta).build();
    }

    @PutMapping("/{id}")
    public ResponseEntityDto updateStudent(@PathVariable Long id, @RequestBody Venta updatedVenta) {
        updatedVenta= ventaService.updateVenta(id,updatedVenta);
        return ResponseEntityDto.builder()._embedded(updatedVenta).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntityDto deleteStudent(@PathVariable Long id) {
        ventaService.deleteVenta(id);
        return ResponseEntityDto.builder()._embedded(null).build();
    }
}

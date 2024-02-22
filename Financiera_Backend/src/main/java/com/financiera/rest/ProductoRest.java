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
import com.financiera.model.entity.Producto;
import com.financiera.service.ProductoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/productos")
public class ProductoRest {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntityDto getAllProductos() {
        System.out.println(productoService.getAllProductos().getProductos().size());
        return ResponseEntityDto.builder()._embedded(productoService.getAllProductos()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntityDto getProductoById(@PathVariable Long id) {
        Optional<Producto> producto = productoService.getProductoById(id);
        
        return ResponseEntityDto.builder()._embedded(producto.get()).build();
    }

    @PostMapping
    public ResponseEntityDto createProducto(@RequestBody Producto producto) {
        producto= productoService.createProducto(producto);
        return ResponseEntityDto.builder()._embedded(producto).build();
    }

    @PutMapping("/{id}")
    public ResponseEntityDto updateStudent(@PathVariable Long id, @RequestBody Producto updatedProducto) {
        updatedProducto= productoService.updateProducto(id,updatedProducto);
        return ResponseEntityDto.builder()._embedded(updatedProducto).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntityDto deleteStudent(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntityDto.builder()._embedded(null).build();
    }
}

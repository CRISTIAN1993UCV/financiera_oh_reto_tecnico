package com.financiera.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financiera.model.dto.ProductosListDto;
import com.financiera.model.entity.Producto;
import com.financiera.repository.ProductoRepository;
import com.financiera.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ProductosListDto getAllProductos() {

        ProductosListDto productosListDto = new ProductosListDto();
        productosListDto.setProductos(productoRepository.findAll());
        return productosListDto;
    }

    @Override
    public Optional<Producto> getProductoById(Long id) {

        return productoRepository.findById(id);
    }

    @Override
    public Producto createProducto(Producto producto) {

        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Long id, Producto updatedProducto) {

        // Producto ProductoDB=productoRepository.getById(id);
        updatedProducto.setId(id);
        return productoRepository.save(updatedProducto);
    }

    @Override
    public void deleteProducto(Long id) {

        productoRepository.deleteById(id);
    }

   
}

package com.financiera.service;

import java.util.List;
import java.util.Optional;

import com.financiera.model.dto.ProductosListDto;
import com.financiera.model.entity.Producto;



public interface ProductoService {
    ProductosListDto getAllProductos();
    
    Optional<Producto> getProductoById(Long id);

    Producto createProducto(Producto producto);

    Producto updateProducto(Long id, Producto updatedProdcuto);

    void deleteProducto(Long id);
}
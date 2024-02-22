package com.financiera.model.dto;

import java.util.List;

import com.financiera.model.entity.Producto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductosListDto  {
    List<Producto> productos;
}

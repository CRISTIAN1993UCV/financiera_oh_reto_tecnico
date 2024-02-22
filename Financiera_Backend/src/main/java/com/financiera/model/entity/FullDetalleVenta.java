package com.financiera.model.entity;

import java.math.BigInteger;
import java.sql.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FullDetalleVenta {
    private String nombre;
    private String precio;
    private Integer cantidad;
    private Integer subtotal;
}


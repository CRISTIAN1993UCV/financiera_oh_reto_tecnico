package com.financiera.model.entity;

import java.math.BigInteger;
import java.sql.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FullDetailVenta {
    private BigInteger id;
    private BigInteger id_cliente;
    private String nombres;
    private String apellidos;
    private Date fecha;
    private BigInteger total;
}


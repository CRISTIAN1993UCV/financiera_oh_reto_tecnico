package com.financiera.model.dto;

import java.util.List;

import com.financiera.model.entity.FullDetailVenta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailVentasListDto {
    List<FullDetailVenta> fullDetailVenta;
}

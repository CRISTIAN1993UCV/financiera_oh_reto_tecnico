package com.financiera.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.financiera.model.entity.DetalleVenta;
import com.financiera.model.entity.FullDetalleVenta;
@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

    @Query("SELECT new com.financiera.model.entity.FullDetalleVenta(" +
            "p.nombre, p.precio, dv.cantidad, dv.cantidad * p.precio AS subtotal) " +
            "FROM DetalleVenta dv " +
            "INNER JOIN dv.producto p " +
            "WHERE dv.venta.id = :id")
    List<FullDetalleVenta> findDetalleVentaByIdVenta(Long id);
}

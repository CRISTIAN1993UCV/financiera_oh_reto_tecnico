package com.financiera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.financiera.model.entity.Venta;
import com.financiera.model.entity.FullDetailVenta;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT new com.financiera.model.entity.FullDetailVenta(" +
            "v.id, c.id, c.nombres, c.apellidos, v.fecha, SUM(p.precio * dv.cantidad) AS total) " +
            "FROM Venta v " +
            "INNER JOIN v.cliente c " +
            "INNER JOIN v.detallesVenta dv " +
            "INNER JOIN dv.producto p " +
            "GROUP BY v.id, c.id, c.nombres, c.apellidos, v.fecha")
    List<FullDetailVenta> findFullList();

    @Query("SELECT new com.financiera.model.entity.FullDetailVenta(" +
            "v.id, c.id, c.nombres, c.apellidos, v.fecha, SUM(p.precio * dv.cantidad) AS total) " +
            "FROM Venta v " +
            "INNER JOIN v.cliente c " +
            "INNER JOIN v.detallesVenta dv " +
            "INNER JOIN dv.producto p " +
            "WHERE v.fecha = :filterDate " +
            "GROUP BY v.id, c.id, c.nombres, c.apellidos, v.fecha")
    List<FullDetailVenta> findFullListFilter(String filterDate);
}

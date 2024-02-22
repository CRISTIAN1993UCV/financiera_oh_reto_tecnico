package com.financiera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financiera.model.entity.Producto;
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

package com.financiera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financiera.model.entity.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

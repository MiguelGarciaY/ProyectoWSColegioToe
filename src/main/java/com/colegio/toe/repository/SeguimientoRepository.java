package com.colegio.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.toe.model.Seguimiento;

@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento, Integer>{
}

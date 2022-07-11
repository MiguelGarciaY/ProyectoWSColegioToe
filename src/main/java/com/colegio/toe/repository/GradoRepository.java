package com.colegio.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.toe.model.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Integer>{
}

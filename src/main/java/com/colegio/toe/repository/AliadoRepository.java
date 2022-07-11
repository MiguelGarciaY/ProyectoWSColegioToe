package com.colegio.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.toe.model.Aliado;

@Repository
public interface AliadoRepository extends JpaRepository<Aliado, Integer>{
}

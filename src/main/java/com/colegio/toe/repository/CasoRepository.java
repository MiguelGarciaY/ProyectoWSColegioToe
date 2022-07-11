package com.colegio.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.toe.model.Caso;

@Repository
public interface CasoRepository extends JpaRepository<Caso, Integer>{
}

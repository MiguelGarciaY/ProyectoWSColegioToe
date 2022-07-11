package com.colegio.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.toe.model.Alumno;
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
}

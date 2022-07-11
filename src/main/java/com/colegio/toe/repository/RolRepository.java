package com.colegio.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.toe.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
}

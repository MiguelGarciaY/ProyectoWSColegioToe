package com.colegio.toe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.toe.model.InformeMedico;

@Repository
public interface InformeMedicoRepository extends JpaRepository<InformeMedico, Integer>{
}

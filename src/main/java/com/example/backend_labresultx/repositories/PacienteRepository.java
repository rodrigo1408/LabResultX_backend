package com.example.backend_labresultx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend_labresultx.domain.paciente.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}

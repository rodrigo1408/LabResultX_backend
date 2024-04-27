package com.example.backend_labresultx.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend_labresultx.domain.exame.ResultadoExame;

public interface ResultadoExameRepository extends JpaRepository<ResultadoExame, Long> {
	List<ResultadoExame> findByPacienteId(Long pacienteId);
}
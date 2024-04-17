package com.example.backend_labresultx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_labresultx.domain.paciente.Paciente;
import com.example.backend_labresultx.domain.paciente.PacienteRequestDTO;
import com.example.backend_labresultx.domain.paciente.PacienteResponseDTO;
import com.example.backend_labresultx.repositories.PacienteRepository;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("paciente")
public class PacienteController {

	@Autowired
	PacienteRepository repository;

	@PostMapping
	public ResponseEntity postPaciente(@RequestBody @Valid PacienteRequestDTO body) {
		Paciente newPaciente = new Paciente(body);

		this.repository.save(newPaciente);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity Paciente() {
		List<PacienteResponseDTO> pacienteList = this.repository.findAll().stream().map(PacienteResponseDTO::new).toList();

		return ResponseEntity.ok(pacienteList);
	}
}

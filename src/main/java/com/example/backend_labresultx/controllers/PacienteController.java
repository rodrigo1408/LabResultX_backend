package com.example.backend_labresultx.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_labresultx.domain.exame.ResultadoExame;
import com.example.backend_labresultx.domain.exame.ResultadoExameResponseDTO;
import com.example.backend_labresultx.domain.paciente.Paciente;
import com.example.backend_labresultx.domain.paciente.PacienteRequestDTO;
import com.example.backend_labresultx.domain.paciente.PacienteResponseDTO;
import com.example.backend_labresultx.exception.MensagemErro;
import com.example.backend_labresultx.repositories.PacienteRepository;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("paciente")
public class PacienteController {

	@Autowired
	PacienteRepository repository;

	@PostMapping
	public ResponseEntity<?> postPaciente(@RequestBody @Valid PacienteRequestDTO body) {
		Paciente newPaciente = new Paciente(body);

		this.repository.save(newPaciente);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity Paciente() {
		List<PacienteResponseDTO> pacienteList = this.repository.findAll().stream().map(PacienteResponseDTO::new).toList();

		if (pacienteList.isEmpty()) {
			MensagemErro mensagemErro = new MensagemErro("Lista de pacientes vazia!");
			return ((BodyBuilder) ResponseEntity.notFound()).body(mensagemErro);
		}

		return ResponseEntity.ok(pacienteList);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPacienteById(@PathVariable Long id) {
	    Optional<Paciente> pacienteOptional = this.repository.findById(id);
	    
	    if (pacienteOptional.isEmpty()) {
	        MensagemErro mensagemErro = new MensagemErro("Nenhum paciente encontrado com o código " + id);
	        return ((BodyBuilder) ResponseEntity.notFound()).body(mensagemErro);
	    }
	    
	    Paciente paciente = pacienteOptional.get();
	    PacienteResponseDTO pacienteResponseDTO = new PacienteResponseDTO(paciente);
	    
	    return ResponseEntity.ok(pacienteResponseDTO);
	}
}

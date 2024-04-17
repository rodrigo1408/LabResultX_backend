package com.example.backend_labresultx.domain.paciente;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacienteRequestDTO(
		@NotBlank 
		String nome,

		@NotNull 
		String email,
		
		@NotNull
		Date dataNascimento
		) { } 
package com.example.backend_labresultx.domain.paciente;

import java.util.Date;

public record PacienteResponseDTO(Long id, String nome, String email, Date dataNascimento ) {
	public PacienteResponseDTO(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getDataNascimento());
	}
}
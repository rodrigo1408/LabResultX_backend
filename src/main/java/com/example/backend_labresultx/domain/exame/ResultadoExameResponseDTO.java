package com.example.backend_labresultx.domain.exame;

import com.example.backend_labresultx.domain.paciente.Paciente;

public record ResultadoExameResponseDTO(Long id, String resultado, TipoExame tipoExame, Paciente paciente) {
	public ResultadoExameResponseDTO(ResultadoExame resultadoExame) {
		this(resultadoExame.getId(), resultadoExame.getResultado(), resultadoExame.getTipoExame(), resultadoExame.getPaciente());
	}
}

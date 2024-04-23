package com.example.backend_labresultx.domain.exame;

import com.example.backend_labresultx.domain.paciente.Paciente;

public record ResultadoExameRequestDTO(String resultado, TipoExame tipoExame, Paciente paciente) {}
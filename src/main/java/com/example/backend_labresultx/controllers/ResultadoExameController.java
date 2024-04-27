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
import com.example.backend_labresultx.domain.exame.ResultadoExameRequestDTO;
import com.example.backend_labresultx.domain.exame.ResultadoExameResponseDTO;
import com.example.backend_labresultx.domain.paciente.Paciente;
import com.example.backend_labresultx.exception.MensagemErro;
import com.example.backend_labresultx.repositories.PacienteRepository;
import com.example.backend_labresultx.repositories.ResultadoExameRepository;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("resultado")
public class ResultadoExameController {

	@Autowired
	ResultadoExameRepository resultadoRepository;

	@Autowired
	PacienteRepository pacienteRepository;
	
	@PostMapping
	public ResponseEntity<?> postResultadoExame(@RequestBody @Valid ResultadoExameRequestDTO body) {
		ResultadoExame newResultadoExame = new ResultadoExame(body);

		this.resultadoRepository.save(newResultadoExame);
		return ResponseEntity.ok().build();
	}

	@GetMapping 
	@SuppressWarnings("rawtypes")
	public ResponseEntity ResultadoExame() {
		List<ResultadoExameResponseDTO> resultadoExameList = this.resultadoRepository.findAll().stream().map(ResultadoExameResponseDTO::new).toList();

	    if (resultadoExameList.isEmpty()) {
	        MensagemErro mensagemErro = new MensagemErro("Lista de exames vazia!");
	        return ((BodyBuilder) ResponseEntity.notFound()).body(mensagemErro);
	    }
	    
		return ResponseEntity.ok(resultadoExameList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getResultadoExameById(@PathVariable Long id) {
	    Optional<ResultadoExame> resultadoExameOptional = this.resultadoRepository.findById(id);
	    
	    if (resultadoExameOptional.isEmpty()) {
	        MensagemErro mensagemErro = new MensagemErro("Nenhum resultado de exame encontrado para o código " + id);
	        return ((BodyBuilder) ResponseEntity.notFound()).body(mensagemErro);
	    }
	    
	    ResultadoExame resultadoExame = resultadoExameOptional.get();
	    ResultadoExameResponseDTO resultadoExameResponseDTO = new ResultadoExameResponseDTO(resultadoExame);
	    
	    return ResponseEntity.ok(resultadoExameResponseDTO);
	}

	
	@GetMapping("/paciente/{pacienteId}")
	public ResponseEntity<?> getResultadoExameByPacienteId(@PathVariable Long pacienteId) {
	    // Verificar se o paciente existe
	    Optional<Paciente> pacienteOptional = pacienteRepository.findById(pacienteId);
	    if (pacienteOptional.isEmpty()) {
	        MensagemErro mensagemErro = new MensagemErro("Nenhum paciente encontrado com o código " + pacienteId);
	        return ((BodyBuilder) ResponseEntity.notFound()).body(mensagemErro);
	    }

	    // Buscar resultados de exame do paciente
	    List<ResultadoExame> resultadoExameList = this.resultadoRepository.findByPacienteId(pacienteId);
	    
	    if (resultadoExameList.isEmpty()) {
	        MensagemErro mensagemErro = new MensagemErro("Nenhum resultado de exame encontrado para o paciente com código " + pacienteId);
	        return ((BodyBuilder) ResponseEntity.notFound()).body(mensagemErro);
	    }
	    
	    List<ResultadoExameResponseDTO> resultadoExameResponseDTOList = resultadoExameList.stream()
	            .map(ResultadoExameResponseDTO::new)
	            .toList();
	    
	    return ResponseEntity.ok(resultadoExameResponseDTOList);
	}
}

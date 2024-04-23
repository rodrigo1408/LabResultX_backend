package com.example.backend_labresultx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_labresultx.domain.exame.ResultadoExame;
import com.example.backend_labresultx.domain.exame.ResultadoExameRequestDTO;
import com.example.backend_labresultx.domain.exame.ResultadoExameResponseDTO;
import com.example.backend_labresultx.repositories.ResultadoExameRepository;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("resultado")
public class ResultadoExameController {

	@Autowired
	ResultadoExameRepository repository;

	@PostMapping
	public ResponseEntity<?> postResultadoExame(@RequestBody @Valid ResultadoExameRequestDTO body) {
		ResultadoExame newResultadoExame = new ResultadoExame(body);

		this.repository.save(newResultadoExame);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	@SuppressWarnings("rawtypes")
	public ResponseEntity ResultadoExame() {
		List<ResultadoExameResponseDTO> resultadoExameList = this.repository.findAll().stream().map(ResultadoExameResponseDTO::new).toList();

		return ResponseEntity.ok(resultadoExameList);
	}
}

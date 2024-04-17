package com.example.backend_labresultx.domain.paciente;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente { 
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "nome_paciente")
    private String nome;
    
    private String email;
    
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    
    public Paciente(PacienteRequestDTO data){
        this.nome = data.nome();
        this.email = data.email();
        this.dataNascimento = data.dataNascimento();
    }
}

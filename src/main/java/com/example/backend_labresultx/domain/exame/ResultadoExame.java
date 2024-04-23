package com.example.backend_labresultx.domain.exame;

import com.example.backend_labresultx.domain.paciente.Paciente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "result_exame")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoExame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String resultado;
	
	@ManyToOne
    @JoinColumn(name = "tipo_exame_id")
    private TipoExame tipoExame;
	
	@ManyToOne
    @JoinColumn(name = "paciente_id")
	Paciente paciente;
	
    public ResultadoExame(ResultadoExameRequestDTO data){
        this.resultado = data.resultado();
        this.tipoExame = data.tipoExame();
        this.paciente  = data.paciente();
    }
}

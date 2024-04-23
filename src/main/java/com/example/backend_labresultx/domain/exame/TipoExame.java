package com.example.backend_labresultx.domain.exame;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tipo_exames")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoExame {
	
	@Id
    private Long id;
    private String tipo;

}

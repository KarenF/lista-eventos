package br.com.java.listaEventos.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.java.listaEventos.entity.Convidado;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventosDTO {

	private Long id;
	@NotBlank
	@Length(min = 3, max = 50, message = "O nome deve conter entre 3 e 50 caracteres")
	private String nome;
	@NotBlank
	@Length(min = 3, max = 50, message = "O local deve conter entre 3 e 50 caracteres")
	private String local;
	@NotBlank
	private String data;
	@NotBlank
	private String horario;
	
	private List<Convidado> convidado;
}

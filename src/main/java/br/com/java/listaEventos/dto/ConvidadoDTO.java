package br.com.java.listaEventos.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.java.listaEventos.entity.Eventos;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConvidadoDTO {

	private Long idConvidado;
	@NotBlank
	@Length(min = 3, max = 50, message = "O nome do convidado deve conter entre 3 e 50 caracteres")
	private String nomeConvidado;
	@NotBlank
	private String rg;
	
	private Eventos eventos;
}

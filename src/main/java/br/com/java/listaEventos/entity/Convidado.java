package br.com.java.listaEventos.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name = "convidado")
@Data
public class Convidado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9214606507062630635L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConvidado;
	@NotBlank
	private String nomeConvidado;

	@JoinColumn(name = "eventos", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Eventos eventos;
}

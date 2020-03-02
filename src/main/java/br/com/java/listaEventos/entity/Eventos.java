package br.com.java.listaEventos.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name = "eventos")
@Data
public class Eventos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2339241340877385457L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(nullable = false)
	private String nome;
	@NotBlank
	@Column(nullable = false)
	private String local;
	@NotBlank
	@Column(nullable = false)
	private String data;
	@NotBlank
	@Column(nullable = false)
	private String horario;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Convidado> convidados;
}

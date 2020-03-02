package br.com.java.listaEventos.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String local;
	@Column(nullable = false)
	private String data;
	@Column(nullable = false)
	private String horario;
	
	@OneToMany
	private List<Convidado> convidados;
}

package br.com.java.listaEventos.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Eventos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2339241340877385457L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String local;
	private String data;
	private String horario;
	
	@OneToMany
	private List<Convidado> convidados;
}

package br.com.java.listaEventos.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Convidado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9214606507062630635L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String rg;
	private String nomeConvidado;
	
	@ManyToOne
	private Eventos eventos;
}

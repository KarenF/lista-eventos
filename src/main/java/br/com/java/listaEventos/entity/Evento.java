package br.com.java.listaEventos.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Evento {

	private String nome;
	private String local;
	private String data;
	private String horario;
}

package br.com.java.listaEventos.entity;

import lombok.Data;

@Data
public class Evento {

	private String nome;
	private String local;
	private String data;
	private String horario;
}

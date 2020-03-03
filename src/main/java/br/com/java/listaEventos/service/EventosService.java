package br.com.java.listaEventos.service;

import java.util.List;

import br.com.java.listaEventos.entity.Eventos;

public interface EventosService {

	Eventos save(Eventos eventos);
	
	List<Eventos> findAll();
	
	Eventos findById(Long id);
	
	void delete(Eventos eventos);
}

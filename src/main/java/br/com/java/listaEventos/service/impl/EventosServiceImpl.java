package br.com.java.listaEventos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.java.listaEventos.entity.Eventos;
import br.com.java.listaEventos.repository.EventosRepository;
import br.com.java.listaEventos.service.EventosService;

public class EventosServiceImpl implements EventosService {

	@Autowired
	EventosRepository eventosRepository;

	@Override
	public Eventos save(Eventos eventos) {
		return eventosRepository.save(eventos);
	}

	@Override
	public List<Eventos> findAll() {
		return eventosRepository.findAll();
	}

	@Override
	public Eventos findById(Long id) {
		return eventosRepository.findById(id);
	}

	@Override
	public void delete(Eventos eventos) {
		eventosRepository.delete(eventos);
	}
}

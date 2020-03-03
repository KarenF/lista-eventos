package br.com.java.listaEventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.java.listaEventos.entity.Convidado;
import br.com.java.listaEventos.entity.Eventos;
import br.com.java.listaEventos.repository.ConvidadoRepository;
import br.com.java.listaEventos.service.ConvidadoService;

public class ConvidadoServiceImpl implements ConvidadoService {

	@Autowired
	ConvidadoRepository convidadoRepository;

	@Override
	public Convidado save(Convidado convidado) {
		return convidadoRepository.save(convidado);
	}

	@Override
	public Iterable<Convidado> findByEventos(Eventos eventos) {
		return convidadoRepository.findByEventos(eventos);
	}

	@Override
	public Convidado findByIdConvidado(Long idConvidado) {
		return convidadoRepository.findByIdConvidado(idConvidado);
	}

	@Override
	public void delete(Convidado convidado) {
		convidadoRepository.delete(convidado);
	}
	
	
}

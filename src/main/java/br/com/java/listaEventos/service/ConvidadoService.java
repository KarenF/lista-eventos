package br.com.java.listaEventos.service;

import br.com.java.listaEventos.entity.Convidado;
import br.com.java.listaEventos.entity.Eventos;

public interface ConvidadoService {
	
	Convidado save(Convidado convidado);

	Iterable<Convidado> findByEventos(Eventos eventos);
	
	Convidado findByIdConvidado(Long idConvidado);
	
	void delete(Convidado convidado);
}

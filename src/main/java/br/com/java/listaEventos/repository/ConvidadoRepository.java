package br.com.java.listaEventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.listaEventos.entity.Convidado;
import br.com.java.listaEventos.entity.Eventos;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {

	Iterable<Convidado> findByEventos(Eventos eventos);
	
	Convidado findByIdConvidado(Long idConvidado);
}

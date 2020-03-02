package br.com.java.listaEventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.listaEventos.entity.Eventos;

public interface EventosRepository extends JpaRepository<Eventos, String>{

	Eventos findById(long id);
}

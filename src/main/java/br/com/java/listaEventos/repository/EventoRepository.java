package br.com.java.listaEventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.listaEventos.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

}

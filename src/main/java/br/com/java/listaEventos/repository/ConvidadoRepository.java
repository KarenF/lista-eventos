package br.com.java.listaEventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.listaEventos.entity.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, String> {

}

package br.com.java.listaEventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.java.listaEventos.entity.Eventos;
import br.com.java.listaEventos.repository.EventosRepository;

@Controller
public class EventosController {

	@Autowired
	private EventosRepository repository;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(Eventos evento) {

		repository.save(evento);

		return "redirect:/cadastrarEvento";
	}
}

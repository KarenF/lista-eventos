package br.com.java.listaEventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.java.listaEventos.entity.Evento;
import br.com.java.listaEventos.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository repository;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(Evento evento) {
		repository.save(evento);
		return "redirect:/cadastrarEvento";
	}
}

package br.com.java.listaEventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.listaEventos.entity.Convidado;
import br.com.java.listaEventos.entity.Eventos;
import br.com.java.listaEventos.repository.ConvidadoRepository;
import br.com.java.listaEventos.repository.EventosRepository;

@Controller
public class EventosController {

	@Autowired
	private EventosRepository Eventosrepository;
	
	@Autowired
	private ConvidadoRepository convidadoRepository;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(Eventos evento) {
		Eventosrepository.save(evento);
		return "redirect:/cadastrarEvento";
	}

	@RequestMapping(value = "/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Eventos> eventos = Eventosrepository.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("id") Long id) {
		Eventos evento = Eventosrepository.findById(id);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", evento);
		return mv;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String detalhesEvento(@PathVariable("id") Long id, Convidado convidado) {
		Eventos evento = Eventosrepository.findById(id);
		convidado.setEventos(evento);
		convidadoRepository.save(convidado);
		return "redirect:/{id}";
	}
}

package br.com.java.listaEventos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.java.listaEventos.entity.Convidado;
import br.com.java.listaEventos.entity.Eventos;
import br.com.java.listaEventos.repository.ConvidadoRepository;
import br.com.java.listaEventos.repository.EventosRepository;

@Controller
public class EventosController {

	@Autowired
	private EventosRepository eventosRepository;

	@Autowired
	private ConvidadoRepository convidadoRepository;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(@Valid Eventos evento, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarEvento";
		}

		eventosRepository.save(evento);
		attributes.addFlashAttribute("mensagem", "Evento adicionado com sucesso");
		return "redirect:/cadastrarEvento";
	}

	@RequestMapping(value = "/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Eventos> eventos = eventosRepository.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("id") Long id) {
		Eventos evento = eventosRepository.findById(id);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", evento);

		Iterable<Convidado> convidados = convidadoRepository.findByEventos(evento);
		mv.addObject("convidados", convidados);

		return mv;
	}

	@RequestMapping("/deletarEvento")
	public String deletarEvento(long id){
		Eventos evento = eventosRepository.findById(id);
		eventosRepository.delete(evento);
		return "redirect:/eventos";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("id") Long id, @Valid Convidado convidado, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/{id}";
		}

		Eventos evento = eventosRepository.findById(id);
		convidado.setEventos(evento);
		convidadoRepository.save(convidado);
		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso");
		return "redirect:/{id}";
	}
	
	@RequestMapping("/deletarConvidado")
	public String deletarConvidado(long rg){
		Convidado convidado = convidadoRepository.findByRg(rg);
		convidadoRepository.delete(convidado);
		
		Eventos evento = convidado.getEventos();
		long idEvento = evento.getId();
		String id = "" + idEvento;
		return "redirect:/" + id;
	}
}

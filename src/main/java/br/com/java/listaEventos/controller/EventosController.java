package br.com.java.listaEventos.controller;

import javax.transaction.Transactional;
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
import br.com.java.listaEventos.validacao.Validacao;

@Controller
public class EventosController {
	
	String cpf;

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

	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.GET)
	public ModelAndView atualizarEventos(@PathVariable(name = "id") Long id) {
		ModelAndView mv = new ModelAndView("evento/formAtualizarEvento");
		Eventos eventos = eventosRepository.findById(id);
		mv.addObject("eventos", eventos);

		return mv;
	}

	@Transactional
	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.POST)
	public String atualizarEventosPost(@PathVariable("id") Long id, @Valid Eventos eventos, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/atualizar/{id}";
		}

		eventosRepository.save(eventos);
		attributes.addFlashAttribute("mensagem", "Evento atualizado com sucesso");
		return "redirect:/eventos";
	}

	@RequestMapping(value = "/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Eventos> eventos = eventosRepository.findAll();
		mv.addObject("eventos", eventos);

		return mv;
	}

	@RequestMapping("/deletarEvento")
	public String deletarEvento(Long id) {
		Eventos evento = eventosRepository.findById(id);
		eventosRepository.delete(evento);
		return "redirect:/eventos";
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

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("id") Long id, @Valid Convidado convidado, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/{id}";
		}

		Eventos evento = eventosRepository.findById(id);
		convidado.setEventos(evento);

		cpf = convidado.getCpf();
		Validacao validacao = new Validacao();
		boolean valido = validacao.validaCPF(cpf);
		if (valido) {
			convidadoRepository.save(convidado);
			attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso");
			return "redirect:/{id}";
		} else {
			attributes.addFlashAttribute("mensagem", "CPF inválido");
			return "redirect:/{id}";
		}
	}

	@RequestMapping(value = "/atualizarConvidado/{idConvidado}", method = RequestMethod.GET)
	public ModelAndView atualizarConvidado(@PathVariable(name = "idConvidado") Long idConvidado) {
		Eventos evento = eventosRepository.findById(idConvidado);
		ModelAndView mv = new ModelAndView("evento/formAtualizarConvidado");
		mv.addObject("evento", evento);

		Convidado convidados = convidadoRepository.findByIdConvidado(idConvidado);
		mv.addObject("convidados", convidados);

		return mv;
	}

	@Transactional
	@RequestMapping(value = "/atualizarConvidado/{idConvidado}", method = RequestMethod.POST)
	public String atualizarConvidadoPost(@PathVariable("idConvidado") Long idConvidado, @Valid Convidado convidado,
			BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/atualizarConvidado/{idConvidado}";
		}

		Eventos evento = convidado.getEventos();
		convidado.setEventos(evento);
		
		cpf = convidado.getCpf();
		Validacao validacao = new Validacao();
		boolean valido = validacao.validaCPF(cpf);
		if (valido) {
			convidadoRepository.save(convidado);
			attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso");
			Long idEvento = evento.getId();
			String id = "" + idEvento;
			return "redirect:/" + id;
		} else {
			attributes.addFlashAttribute("mensagem", "CPF inválido");
			return "redirect:/atualizarConvidado/{idConvidado}";
		}
	}

	@RequestMapping("/deletarConvidado")
	public String deletarConvidado(Long idConvidado) {
		Convidado convidado = convidadoRepository.findByIdConvidado(idConvidado);
		convidadoRepository.delete(convidado);

		Eventos evento = convidado.getEventos();
		Long idEvento = evento.getId();
		String id = "" + idEvento;
		return "redirect:/" + id;
	}
}

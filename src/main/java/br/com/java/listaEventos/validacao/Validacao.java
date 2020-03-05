package br.com.java.listaEventos.validacao;

import java.util.List;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

public class Validacao {
	
	public boolean validaCPF(String cpf) {

		CPFValidator cpfValidator = new CPFValidator();
		List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
		if (erros.size() > 0) {
			System.out.println(erros);
			return false;
		} else
			return true;
	}
}

package br.com.java.listaEventos.validacao;

import java.util.List;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.java.listaEventos.entity.Convidado;

public class Validacao {
	
	Convidado convidado = new Convidado();
	String cpf = convidado.getCpf();
	boolean valido = valida(cpf);

	public boolean valida(String cpf) {

		CPFValidator cpfValidator = new CPFValidator();
		List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
		if (erros.size() > 0) {
			System.out.println(erros);
			return false;
		} else
			return true;
	}
}

package br.com.project.motoboy.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.project.motoboy.model.Cliente;
import br.com.project.motoboy.service.ClienteService;

public class ClienteValidation implements Validator {

	private ClienteService clienteService;

	public ClienteValidation(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public boolean supports(Class<?> clazz) {
		return Cliente.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "sobrenome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "cpf", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "celular", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senha", "field.required.senha.null");

		Cliente cliente = (Cliente) target;

		if (clienteService.localizaPorEmail(cliente.getEmail()) != null) {
			errors.rejectValue("email", "field.required.emailregistrado");
		}
		if (clienteService.localizaPorCpf(cliente) != null) {
			errors.rejectValue("cpf", "field.required.cpfregistrado");
		}

		if (cliente.getSenha().length() < 8) {
			errors.rejectValue("senha", "field.required.pequena");
		}

		if (cliente.getCelular().length() < 14 || cliente.getCelular().length() > 14) {
			errors.reject("celular", "field.required");
		}
		if (cliente.getCpf().length() < 14 || cliente.getCpf().length() > 14) {
			errors.reject("cpf", "field.require");
		}

	}

}

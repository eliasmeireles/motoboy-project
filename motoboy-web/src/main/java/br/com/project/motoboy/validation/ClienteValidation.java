package br.com.project.motoboy.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.project.motoboy.dao.ClienteValidaDao;
import br.com.project.motoboy.model.Cliente;

public class ClienteValidation implements Validator {

	@Autowired
	ClienteValidaDao valida;
	
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
		
		
		if (valida.validaEmail(cliente)) {
			errors.rejectValue("email", "field.required.emailregistrado");
		}
		if (valida.validaCpf(cliente)) {
			errors.rejectValue("cpf", "field.required.cpfregistrado");
		}
		

		if (cliente.getSenha().length() < 8) {
			errors.rejectValue("senha", "field.required.pequena");
		}
		
		if(cliente.getCelular().length() < 14 || cliente.getCelular().length() > 14) {
			errors.reject("celular", "field.required");
		}
		if(cliente.getCpf().length() < 14 || cliente.getCpf().length() > 14) {
			errors.reject("cpf", "field.require");
		}
		
	}

}

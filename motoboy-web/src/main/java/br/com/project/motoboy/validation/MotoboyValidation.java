package br.com.project.motoboy.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.project.motoboy.dao.MotoboyValidaDao;
import br.com.project.motoboy.model.Motoboy;

public class MotoboyValidation implements Validator {

	private MotoboyValidaDao valida;

	public MotoboyValidation(MotoboyValidaDao valida) {
		this.valida = valida;
	}

	public boolean supports(Class<?> clazz) {
		return Motoboy.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "sobrenome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "cpf", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "celular", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senha", "field.required.senha.null");

		Motoboy motoboy = (Motoboy) target;
		
		
		if (valida.validaEmail(motoboy)) {
			errors.rejectValue("email", "field.required.emailregistrado");
		}
		if (valida.validaCpf(motoboy)) {
			errors.rejectValue("cpf", "field.required.cpfregistrado");
		}
		

		if (motoboy.getSenha().length() < 8) {
			errors.rejectValue("senha", "field.required.pequena");
		}
		
		if(motoboy.getCelular().length() < 14 || motoboy.getCelular().length() > 14) {
			errors.reject("celular", "field.required");
		}
		if(motoboy.getCpf().length() < 14 || motoboy.getCpf().length() > 14) {
			errors.reject("cpf", "field.require");
		}
		
	}
}

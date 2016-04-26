package br.com.project.motoboy.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.project.motoboy.model.Motoboy;
import br.com.project.motoboy.service.MotoboyService;

public class MotoboyValidation implements Validator {

	private MotoboyService motoboyService;

	public MotoboyValidation(MotoboyService motoboyService) {
		this.motoboyService = motoboyService;
	}

	public boolean supports(Class<?> clazz) {
		return Motoboy.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "sobrenome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "celular", "field.required");

		Motoboy motoboy = (Motoboy) target;
		
		
		if (motoboy.getFotoPerfil().length() > 150) {
			errors.rejectValue("fotoPerfil", "field.required.outsize");
		}
		
		if (motoboyService.motoboyEmail(motoboy.getEmail())) {
			errors.rejectValue("email", "field.required.emailregistrado");
		}
		if (motoboyService.motoboyCpf(motoboy.getCpf())) {
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

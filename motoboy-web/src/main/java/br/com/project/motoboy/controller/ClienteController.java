package br.com.project.motoboy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.motoboy.dao.ClienteDao;
import br.com.project.motoboy.model.Cliente;
import br.com.project.motoboy.security.PasswordEncryptor;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteDao clienteDao;

	@RequestMapping("/solicitante")
	public ModelAndView solicitante() {
		return new ModelAndView("/cliente/form");
	}

	@RequestMapping("/cadastrar")
	public ModelAndView cadastrar(Cliente cliente, String senhaVerificador) {

		cliente.setSenha(PasswordEncryptor.passwordEncripter(cliente.getSenha()).toString());
		clienteDao.gravar(cliente);

		return solicitante();
	}
}

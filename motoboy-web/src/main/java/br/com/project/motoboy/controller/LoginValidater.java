package br.com.project.motoboy.controller;

import org.springframework.web.servlet.ModelAndView;

import br.com.project.motoboy.dao.ClienteDao;
import br.com.project.motoboy.dao.MotoboyDao;
import br.com.project.motoboy.model.Cliente;
import br.com.project.motoboy.model.Motoboy;
import br.com.project.motoboy.security.PasswordEncryptor;

public class LoginValidater {

	public static ModelAndView localizaCliente(Cliente c, ClienteDao clienteDao) {
		c.setSenha(PasswordEncryptor.passwordEncripter(c.getSenha()).toString());

		Cliente usuario = (Cliente) clienteDao.localiza(c);

		if (c.getSenha().equals(usuario.getSenha())) {
			return modelAndViewCliente(usuario);
		}

		return HomeController.home();
	}

	public static ModelAndView localizaMotoboy(Motoboy m, MotoboyDao motoboyDao) {
		m.setSenha(PasswordEncryptor.passwordEncripter(m.getSenha()).toString());

		Motoboy usuario = (Motoboy) motoboyDao.localiza(m);

		if (m.getSenha().equals(usuario.getSenha())) {
			return modelAndViewCliente(usuario);
		}

		return HomeController.home();
	}

	private static ModelAndView modelAndViewCliente(Object usuario) {
		ModelAndView modelAndView = new ModelAndView("logado");
		modelAndView.addObject("user", usuario);
		return modelAndView;
	}

}

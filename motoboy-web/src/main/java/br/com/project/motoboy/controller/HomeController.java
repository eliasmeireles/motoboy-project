package br.com.project.motoboy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.motoboy.dao.ClienteDao;
import br.com.project.motoboy.dao.MotoboyDao;
import br.com.project.motoboy.model.Cliente;
import br.com.project.motoboy.model.Motoboy;

@Controller
public class HomeController {

	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private MotoboyDao motoboyDaoo;

	@RequestMapping("/")
	public static ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping("/logar")
	public ModelAndView logar(Motoboy m, Cliente c) {
		try {
			try {
				return LoginValidater.localizaMotoboy(m, motoboyDaoo);
			} catch (Exception e) {
				return LoginValidater.localizaCliente(c, clienteDao);
			}
		} catch (Exception e) {
			return home();
		}
	}
}

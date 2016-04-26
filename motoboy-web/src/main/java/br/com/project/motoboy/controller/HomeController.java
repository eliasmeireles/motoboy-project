package br.com.project.motoboy.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.motoboy.model.Cliente;

@Controller
@RequestMapping
public class HomeController {

	@RequestMapping(method = GET)
	public ModelAndView home() {
		Cliente c = new Cliente();
		return new ModelAndView("home", "user", c);
	}
}

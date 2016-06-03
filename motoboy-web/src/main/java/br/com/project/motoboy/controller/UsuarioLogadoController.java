package br.com.project.motoboy.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/meus_dados")
public class UsuarioLogadoController {

	@RequestMapping(method = GET)
	public ModelAndView dados() {
		return new ModelAndView("/meus-dados");
	}
}

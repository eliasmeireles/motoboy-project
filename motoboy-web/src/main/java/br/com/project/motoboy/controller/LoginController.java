package br.com.project.motoboy.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = "/logado", method = GET)
	public String logado() {
		return "logado";
	}
}

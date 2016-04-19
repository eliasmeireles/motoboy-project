package br.com.project.motoboy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/moto")
public class MotoController {
	
	@RequestMapping("/nova")
	public ModelAndView motoForm() {
		return new ModelAndView("/moto/form");
	}
	
}

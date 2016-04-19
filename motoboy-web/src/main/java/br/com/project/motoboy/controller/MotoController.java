package br.com.project.motoboy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.motoboy.dao.MotoDao;
import br.com.project.motoboy.model.Cliente;
import br.com.project.motoboy.model.Moto;

@Controller
@RequestMapping("/moto")
public class MotoController {
	@Autowired
	private MotoDao motoDao;
	
	@RequestMapping("/nova")
	public ModelAndView motoForm() {
		return new ModelAndView("/moto/form");
	}
	
	@RequestMapping("/cadastrar")
	public ModelAndView cadastrar(Moto moto, String cliente_id) {
		ModelAndView modelAndView = new ModelAndView("/moto/form");
		
		moto.setCliente_id(cliente_id);
		
		System.out.println(moto);
		
		motoDao.gravar(moto);
		
		return modelAndView;
	}
	
}

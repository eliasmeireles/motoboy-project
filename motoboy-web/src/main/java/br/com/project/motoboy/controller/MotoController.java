package br.com.project.motoboy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.motoboy.dao.MotoDao;
import br.com.project.motoboy.dao.MotoboyDao;
import br.com.project.motoboy.model.Moto;
import br.com.project.motoboy.model.Motoboy;

@Controller
@RequestMapping("/moto")
public class MotoController {
	
	@Autowired
	private MotoDao motoDao;
	@Autowired
	MotoboyDao motoboyDao;
	
	@RequestMapping("/nova")
	public ModelAndView motoForm() {
		return new ModelAndView("/moto/form");
	}
	
	@RequestMapping("/cadastrar")
	public ModelAndView cadastrar(Moto moto, String email) {
		ModelAndView modelAndView = new ModelAndView("/moto/form");
		
		Motoboy m = new Motoboy();
		
		m.setEmail(email);
		
		
		System.out.println(m.getEmail());
		
		Motoboy motoboy = motoboyDao.localiza(m);
		
		moto.setMotoboy_id(motoboy.getId());
		
		motoDao.gravar(moto);
		
		return modelAndView;
	}
	
}

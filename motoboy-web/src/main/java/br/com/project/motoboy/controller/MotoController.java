package br.com.project.motoboy.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.motoboy.dao.MotoDao;
import br.com.project.motoboy.dao.MotoboyDao;
import br.com.project.motoboy.model.Moto;

@Controller
@RequestMapping("/moto")
public class MotoController {
	
	@Autowired
	private MotoDao motoDao;
	@Autowired
	MotoboyDao motoboyDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView motoForm(Moto moto) {
		return new ModelAndView("/moto/form", "moto", moto);
	}
	
	@RequestMapping(value = "/cadastrar", method = POST)
	public ModelAndView cadastrar(Moto moto) {
		ModelAndView modelAndView = new ModelAndView("/moto/form");
		
		motoDao.gravar(moto);
		
		return modelAndView;
	}
	
}

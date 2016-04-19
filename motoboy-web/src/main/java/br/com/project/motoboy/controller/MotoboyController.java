package br.com.project.motoboy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.motoboy.dao.MotoboyDao;
import br.com.project.motoboy.model.Motoboy;
import br.com.project.motoboy.security.PasswordEncryptor;

@Controller
@RequestMapping("/motoboy")
public class MotoboyController {

	@Autowired
	private MotoboyDao motoboyDao;

	@RequestMapping("/novo")
	public ModelAndView motoboy() {
		return new ModelAndView("/motoboy/form");
	}

	@RequestMapping("/cadastrar")
	public ModelAndView cadastrar(Motoboy motoboy, String senhaVerificador) {

		motoboy.setSenha(PasswordEncryptor.passwordEncripter(motoboy.getSenha()).toString());

		System.out.println(motoboy.getSenha());

		motoboyDao.gravar(motoboy);

		return motoboy();
	}

}

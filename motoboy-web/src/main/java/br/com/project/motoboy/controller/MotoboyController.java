package br.com.project.motoboy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.project.motoboy.dao.MotoboyDao;
import br.com.project.motoboy.model.Motoboy;
import br.com.project.motoboy.security.PasswordEncryptor;

@Controller
@RequestMapping("/motoboy")
public class MotoboyController {

	@Autowired
	private MotoboyDao motoboyDao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView motoboy() {
		return new ModelAndView("/motoboy/form");
	}

	@RequestMapping(value = "/sucsses", method = RequestMethod.GET)
	public ModelAndView sucsses() {
		return new ModelAndView("/motoboy/sucsses");
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Motoboy motoboy, BindingResult result, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			System.out.println("Entrei no error");
			
			List<ObjectError> erros = result.getAllErrors();
			
			for (ObjectError objectError : erros) {
				System.out.println(objectError);
			}
			return motoboy();
		}
		
		motoboy.setSenha(PasswordEncryptor.passwordEncripter(motoboy.getSenha()).toString());

		motoboyDao.gravar(motoboy);

		redirectAttributes.addFlashAttribute("user", motoboy);

		return new ModelAndView("redirect:/motoboy/sucsses");
	}

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView lista() {
		Motoboy motoboy = new Motoboy();
		List<Motoboy> motoboys = motoboyDao.localizaTodos(motoboy);

		ModelAndView modelAndView = new ModelAndView("/motoboy/lista");
		modelAndView.addObject("listaDeMotoboys", motoboys);

		return modelAndView;
	}

}

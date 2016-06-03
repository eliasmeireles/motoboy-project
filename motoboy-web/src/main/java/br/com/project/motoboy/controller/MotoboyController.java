package br.com.project.motoboy.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.project.motoboy.infra.FileSaver;
import br.com.project.motoboy.model.Motoboy;
import br.com.project.motoboy.security.PasswordEncryptor;
import br.com.project.motoboy.service.MotoboyService;
import br.com.project.motoboy.validation.MotoboyValidation;

@Controller
@RequestMapping("/motoboy")
public class MotoboyController {

	@Autowired
	private MotoboyService motoboyService;
	@Autowired
	private FileSaver fileSaver;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new MotoboyValidation(motoboyService));
	}

	@RequestMapping(method = GET)
	public ModelAndView motoboy(Motoboy motoboy) {
		return new ModelAndView("/motoboy/form", "motoboy", motoboy);
	}
	
	@RequestMapping(value = "/cadastrar", method = GET)
	public ModelAndView registrar(Motoboy motoboy) {
		return new ModelAndView("/motoboy/form", "motoboy", motoboy);
	}

	@RequestMapping(value = "/cadastrar", method = POST)
	public ModelAndView cadastrar(MultipartFile foto, @Valid Motoboy motoboy, BindingResult result,
			RedirectAttributes redirectAttributes) {
		motoboy.setSenha(PasswordEncryptor.passwordEncripter(motoboy.getSenha()).toString());
		
		
		if (foto.isEmpty()) {
			motoboy.setFotoPerfil("");
		}
		
		if (!foto.getOriginalFilename().isEmpty()) {
			String imageName = PasswordEncryptor.passwordEncripter(foto.getOriginalFilename() + motoboy.getEmail())
					.toString();

			String path = fileSaver.write(imageName, "motoboy-image", foto);
			motoboy.setFotoPerfil(path);
		}
		
		if (result.hasErrors()) {
			return registrar(motoboy);
		}

		motoboyService.gravar(motoboy);

		redirectAttributes.addFlashAttribute("motoboy", motoboy);

		return new ModelAndView("redirect:/motoboy/sucsses");
	}

	@RequestMapping(value = "/sucsses", method = GET)
	public ModelAndView sucsses() {
		return new ModelAndView("/motoboy/sucsses");
	}

	@RequestMapping(value = "/lista", method = GET)
	public ModelAndView lista() {
		List<Motoboy> motoboys = motoboyService.localizaTodos();

		ModelAndView modelAndView = new ModelAndView("/motoboy/lista");
		modelAndView.addObject("listaDeMotoboys", motoboys);

		return modelAndView;
	}

	@RequestMapping(value = "/login", method = POST)
	public ModelAndView logar(Motoboy motoboy, HttpSession session) {
		motoboy.setSenha(PasswordEncryptor.passwordEncripter(motoboy.getSenha()).toString());
		Motoboy m = motoboyService.localiza(motoboy);
		
		if (m != null) {
			session.setAttribute("connectedUser", m);
			return new ModelAndView("redirect:/login/logado");
		} else {
			return new ModelAndView("redirect:/");
		}
	}

}

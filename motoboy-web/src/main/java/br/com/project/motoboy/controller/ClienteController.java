package br.com.project.motoboy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.project.motoboy.dao.ClienteDao;
import br.com.project.motoboy.model.Cliente;
import br.com.project.motoboy.security.PasswordEncryptor;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteDao clienteDao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView solicitante() {
		return new ModelAndView("cliente/form");
	}
	
	@RequestMapping(value = "/sucsses", method = RequestMethod.GET)
	public ModelAndView sucsses() {
		return new ModelAndView("cliente/sucsses");
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrar(Cliente cliente, RedirectAttributes redirectAttributes) {

		cliente.setSenha(PasswordEncryptor.passwordEncripter(cliente.getSenha()).toString());
		clienteDao.gravar(cliente);
		redirectAttributes.addFlashAttribute("user", cliente);
		
		return new ModelAndView("redirect:/cliente/sucsses");
	}
}

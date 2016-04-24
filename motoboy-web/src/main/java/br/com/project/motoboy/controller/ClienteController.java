package br.com.project.motoboy.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.project.motoboy.dao.ClienteDao;
import br.com.project.motoboy.model.Cliente;
import br.com.project.motoboy.security.PasswordEncryptor;
import br.com.project.motoboy.validation.ClienteValidation;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteDao clienteDao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ClienteValidation());
	}
	
	@RequestMapping(method = GET)
	public ModelAndView solicitante(Cliente cliente) {
		return new ModelAndView("cliente/form", "cliente", cliente);
	}
	
	
	@RequestMapping(value = "/cadastrar", method = POST)
	public ModelAndView cadastrar(@Valid Cliente cliente, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return solicitante(cliente);
		}
		
		cliente.setSenha(PasswordEncryptor.passwordEncripter(cliente.getSenha()).toString());
		clienteDao.gravar(cliente);
		redirectAttributes.addFlashAttribute("cliente", cliente);
		
		return new ModelAndView("redirect:/cliente/sucsses");
	}

	@RequestMapping(value = "/sucsses", method = GET)
	public ModelAndView sucsses() {
		return new ModelAndView("cliente/sucsses");
	}
	
	@RequestMapping(value = "/login", method = POST)
	public ModelAndView logar(Cliente cliente, RedirectAttributes redirectAttributes) {
		cliente.setSenha(PasswordEncryptor.passwordEncripter(cliente.getSenha()).toString());
		Cliente c = (Cliente) clienteDao.localiza(cliente);
		
		redirectAttributes.addFlashAttribute("user", c);
		ModelAndView modelAndView = new ModelAndView("redirect:/logado");
		return modelAndView;
	}
}

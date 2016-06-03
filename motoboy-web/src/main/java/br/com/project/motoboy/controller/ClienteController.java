package br.com.project.motoboy.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
import br.com.project.motoboy.model.Cliente;
import br.com.project.motoboy.security.PasswordEncryptor;
import br.com.project.motoboy.service.ClienteService;
import br.com.project.motoboy.validation.ClienteValidation;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private FileSaver fileSaver;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ClienteValidation(clienteService));
	}

	@RequestMapping(method = GET)
	public ModelAndView solicitante(Cliente cliente) {
		return new ModelAndView("cliente/form", "cliente", cliente);
	}

	@RequestMapping(value = "/cadastrar", method = POST)
	public ModelAndView cadastrar(MultipartFile foto, @Valid Cliente cliente, BindingResult result,
			RedirectAttributes redirectAttributes) {

		cliente.setSenha(PasswordEncryptor.passwordEncripter(cliente.getSenha()).toString());

		if (!foto.getOriginalFilename().isEmpty()) {
			if (foto.getOriginalFilename().length() > 20) {
				cliente.setFotoPerfil("nomegrande");
			} else {
				String imageName = PasswordEncryptor.passwordEncripter(foto.getOriginalFilename() + cliente.getEmail())
						.toString();

				String path = fileSaver.write(imageName, "cliente-image", foto);
				cliente.setFotoPerfil(path);
			}
		}

		if (result.hasErrors()) {
			return solicitante(cliente);
		}

		clienteService.gravar(cliente);
		redirectAttributes.addFlashAttribute("cliente", cliente);

		return new ModelAndView("redirect:/cliente/sucsses");
	}

	@RequestMapping(value = "/sucsses", method = GET)
	public ModelAndView sucsses() {
		return new ModelAndView("cliente/sucsses");
	}

	@RequestMapping(value = "/login", method = POST)
	public ModelAndView logar(Cliente cliente, HttpSession session) {
		cliente.setSenha(PasswordEncryptor.passwordEncripter(cliente.getSenha()).toString());
		
		Cliente c = clienteService.localiza(cliente);
		if (c != null) {
			session.setAttribute("connectedUser", c);
			return new ModelAndView("redirect:/login/logado");
		} else {
			return new ModelAndView("redirect:/");
		}
	}
}

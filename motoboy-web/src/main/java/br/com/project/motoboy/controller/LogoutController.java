package br.com.project.motoboy.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/logout")
public class LogoutController  {
	
	@RequestMapping(method = POST)
	public ModelAndView logOff(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
}

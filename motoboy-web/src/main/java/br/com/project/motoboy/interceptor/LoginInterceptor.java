package br.com.project.motoboy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {

		String uri = request.getRequestURI();
		if (uri.endsWith("/") || 
				uri.endsWith("/motoboy-web/motoboy/cadastrar") || 
				uri.endsWith("/motoboy-web/cliente/cadastrar") || 
				uri.endsWith("/motoboy-web/cliente") || 
				uri.endsWith("/motoboy-web/motoboy")  || 
				uri.endsWith("/motoboy-web/cliente/login") ||
				uri.endsWith("/motoboy-web/motoboy/login") ||
				uri.contains("resources")) {
			return true;
		}

		if (request.getSession().getAttribute("connectedUser") != null) {
			return true;
		}
		response.sendRedirect("/motoboy-web");
		return false;
	}

}

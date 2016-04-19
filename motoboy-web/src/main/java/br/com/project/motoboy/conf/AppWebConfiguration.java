package br.com.project.motoboy.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.project.motoboy.controller.HomeController;
import br.com.project.motoboy.dao.ClienteDao;
import br.com.project.motoboy.dao.MotoboyDao;

@EnableWebMvc
@ComponentScan(basePackageClasses = { HomeController.class, ClienteDao.class, MotoboyDao.class })
public class AppWebConfiguration {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}

}

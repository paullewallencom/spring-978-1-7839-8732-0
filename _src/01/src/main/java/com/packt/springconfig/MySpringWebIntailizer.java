package com.packt.springconfig;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
 

public class MySpringWebIntailizer implements WebApplicationInitializer {
	 
	public void onStartup(ServletContext servletContext) throws ServletException {
	 
	 AnnotationConfigWebApplicationContext webcontext = new AnnotationConfigWebApplicationContext();
	 webcontext.register(MySpringConfiguration.class);
	 
	 webcontext.setServletContext(servletContext);
	 
	 Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webcontext));
	 servlet.addMapping("/");
	 servlet.setLoadOnStartup(1);
	 
	 }
	 
	}


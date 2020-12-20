package com.packt.springconfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
 
@Configuration //Annotation to say this class as a configuration
@ComponentScan("com.packt")//annotation for package scan in spring
@EnableWebMvc //annotation to enable spring webmvc
public class MySpringConfiguration {
	 @Bean
		 public UrlBasedViewResolver setupViewResolver() {
		 UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		 resolver.setPrefix("/WEB-INF/myviews/");
		 resolver.setSuffix(".jsp");
		 resolver.setViewClass(JstlView.class);
		 return resolver;

}
}

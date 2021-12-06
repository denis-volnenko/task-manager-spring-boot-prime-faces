package school.volnenko.tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  http://localhost:8080/
 *  http://localhost:8080/v2/api-docs
 *  http://localhost:8080/swagger-ui.html#/
 *  http://localhost:8080/services/ProjectEndpoint?wsdl
 *  http://localhost:8080/services/TaskEndpoint?wsdl
 */
@SpringBootApplication
public class Application  {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ServletRegistrationBean jsfServletRegistration(ServletContext servletContext) {
		// spring boot only works if this is set
		servletContext.setInitParameter("primefaces.FONT_AWESOME", "true");
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		final ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new FacesServlet());
		servletRegistrationBean.setUrlMappings(Arrays.asList("*.xhtml"));
		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}

}
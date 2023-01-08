package ar.com.eacosta.springboot.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateAppConfig {
	
	/* 
	 * El RestTemplate es un cliente para trabjar con API REST
	 * para poder acceder a recursosq eu estan en otros microservicios
	 * 
	 * 
	 * 
	 * */
	
	@Bean("clientRest")
	public RestTemplate registrerRestTemplate() {
		return new RestTemplate();
	}
	
	

}

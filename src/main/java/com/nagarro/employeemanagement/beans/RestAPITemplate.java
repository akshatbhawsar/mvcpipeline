package com.nagarro.employeemanagement.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * A bean for the RestTemplate in the App 
 * used for provide all the methods for REST API Calling 
 * @author akshatBhawsar
 *
 */
@Configuration
public class RestAPITemplate {
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		
		return  new RestTemplate();
			
			
	}

}

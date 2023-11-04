package aub.c8.jira.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignClientConfiguration {
	
	@Value("${jira.api.call}") 
	private String API_KEY;
	
	@Value("${jira.email}") 
	private String EMAIL;
	
	@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
         return new BasicAuthRequestInterceptor(EMAIL, API_KEY);
    }
}

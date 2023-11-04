package aub.c8.jira.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignClientConfiguration {
	@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
         return new BasicAuthRequestInterceptor("ayoub@hgrsolutions.io", "ATATT3xFfGF0ydiiPuAJHqIm9VROuZFD77VLEjFDYEi4_HveDJpa2tW6AXXi06Agc-Op3AFQ8n5Ts0dVsRGolMD7WtszGWSysUYQxJ0-racFmGvdOtc7Y1Z-8W6Nis2W7w4yIN7e7knDZzk3c6cieHBKbZQITD957vNUP1_ocaVNFpk4twZpJMA=5978A4DC");
    }
}

package aub.c8.jira.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignClientConfiguration {
	@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
         return new BasicAuthRequestInterceptor("ayoub@hgrsolutions.io", "ATATT3xFfGF0r7jNO55-1xFPfUXG52wzDj9xw-Ow42kaFM7MeYHar9eYH4cO9ed7m7De7NEGiAcLFmGXkYYdAxcHQkkI-a4cD2osGMl3j12b5NpIKeviFLjPeqv2mDzJVcNgwe5dlyEaUAV3ZX7QMAMM0l_R6MNb6I-zijcGHpp2pjQb1WnNhQ0=FB165FF5");
    }
}

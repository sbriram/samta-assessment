package com.samta.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/*
 * This configuration class is helpful for creating the bean of WebClient.
 */
@Configuration
public class WebClientConfiguration {

	@Bean
	public WebClient webClient() {

		return WebClient.builder().build();
	}

}

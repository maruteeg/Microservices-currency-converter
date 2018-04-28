package com.vegas.converter.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;

@Configuration
@EnableFeignClients(basePackages = { "com.vegas.converter.service.proxy" })
public class FeinClientConfiguration extends FeignClientConfiguration {

	@Bean
	BasicAuthorizationInterceptor basicAuthentication() {
		return new BasicAuthorizationInterceptor("user", "user");
	}

}

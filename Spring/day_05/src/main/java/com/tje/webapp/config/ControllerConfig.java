package com.tje.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tje.webapp.RegisterController;

@Configuration
public class ControllerConfig {
	@Bean
	public RegisterController registerController() {
		return new RegisterController();
	}
}

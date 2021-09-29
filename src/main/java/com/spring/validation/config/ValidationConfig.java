package com.spring.validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

//@Configuration
class ValidationConfig {
	
	//When using hibernate-validator without spring-boot-validation
	//@Bean
	MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}
}

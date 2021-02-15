package com.app;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class AppConfiguration {

	Logger log = LoggerFactory.getLogger(AppConfiguration.class);

	@Bean
	public Docket AppSwaggerConfig() {
		log.debug("Swagger Configuration");
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(generateAPIInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.app"))
				.build();
	}

	private ApiInfo generateAPIInfo() {
		return new ApiInfo("Demo Swagger","Implementing Swagger","1.0", "", getContacts(), "", "", new ArrayList());
	}

	private Contact getContacts() {
		return new Contact("Kiran Thota", "", "kiranthota17@gmail.com");
	}
}

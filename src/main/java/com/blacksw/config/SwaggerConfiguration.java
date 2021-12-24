package com.blacksw.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.net.HttpHeaders;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	private static final String API_NAME = "TEST API";
	private static final String API_VERSION = "0.0.1";
	private static final String API_DESCRIPTION = "This is a test swagger document.";
	
	@Bean
	public Docket restAPI() {
		
		Parameter paramterBuilder = new ParameterBuilder()
				.name(HttpHeaders.AUTHORIZATION)
				.description("Access Token")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false)
				.build();
		
		/*
		List<Parameter> globalParamters = new ArrayList<>();
		globalParamters.add(paramterBuilder);
		*/
		
		return new Docket(DocumentationType.SWAGGER_2)
		//		.globalOperationParameters(globalParamters)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.blacksw.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(API_NAME)
				.version(API_VERSION)
				.description(API_DESCRIPTION)
				.build();
	}
	
}

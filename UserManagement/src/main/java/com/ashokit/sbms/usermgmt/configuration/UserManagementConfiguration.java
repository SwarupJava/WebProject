

package com.ashokit.sbms.usermgmt.configuration;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
public class UserManagementConfiguration
{
	/*
	 * @Bean public Docket getDocket() { return new
	 * Docket(DocumentationType.SWAGGER_2) .select()
	 * .apis(RequestHandlerSelectors.basePackage(
	 * "com.ashokit.sbms.usermgmt.controller")) .paths(PathSelectors.any()).build();
	 * }
	 */
    
    
    
    @Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ashokit.sbms.usermgmt.controller"))
				.paths(PathSelectors.any())
				.build();
	}
    
    private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Ashok IT API")
				.description("JavaInUse API reference for developers")
				.termsOfServiceUrl("http://ashokit.in")
				.contact("ashokitschool@gmail.com").license("Ashok IT License")
				.licenseUrl("ashokitschool@gmail.com").version("1.0").build();
	}
}

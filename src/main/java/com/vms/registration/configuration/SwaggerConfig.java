package com.vms.registration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@Component
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vms.registration.controller"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaData());
    }
        private ApiInfo metaData() {
            ApiInfo apiInfo = new ApiInfo(
                    "Vehicle Registration Service",
                    "",
                    "",
                    "",
                    new Contact("", "", ""),
                    "",
                    "");
            return apiInfo;
        }
}

package com.api.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket getBean() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .paths(PathSelectors.regex("/ifood-community/.*"))
                .build()
                .apiInfo(getInfo());
    }
    private ApiInfo getInfo() {
        return new ApiInfoBuilder()
                .title("API Ecommerce Food Community")
                .description("Sacola API para Servir uma Aplicação de Delivery")
                .build();
    }
    private Contact contact() {
        return new Contact("Jefferson Pedro",
                "https://www.linkedin.com/in/jefferson-pedro-8a6264b9/",
                "jeffersonpedo05@gmail.com");
      }
}


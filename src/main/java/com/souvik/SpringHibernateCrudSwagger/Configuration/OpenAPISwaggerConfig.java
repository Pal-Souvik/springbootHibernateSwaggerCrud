package com.souvik.SpringHibernateCrudSwagger.Configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;



@Configuration
public class OpenAPISwaggerConfig{
	


	@Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/api/**")
                .build();
    }
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info ()
                .title("My API")
                .version("1.0")
                .description("Description of my API")
                .license(new License()
                		.name("Apache 2.0 | Souvik Pal")
                		.url("http://springdoc.org")));
    }

	
}

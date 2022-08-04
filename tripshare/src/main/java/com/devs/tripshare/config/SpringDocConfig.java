package com.devs.tripshare.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("TripShare - API")
                        .version("v1.0.0")
                        .description("API REST - Trip Share: Cálculo de gasto de combustível")
                ).externalDocs(new ExternalDocumentation()
                        .description("Código fonte do TripShare")
                        .url("https://github.com/mateusCoder/TripShare"));
    }
}

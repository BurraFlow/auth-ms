package co.com.authentication.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Authentication Microservice")
            .version("1.0.0")
            .description(
                "API documentation for the Authentication microservice built with Spring WebFlux and Scaffold Clean Architecture.")
            .contact(new Contact()
                .name("Makinyel")
                .email("makinyel@example.com")
            )
        );
  }
}

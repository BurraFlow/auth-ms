package co.com.authentication.api;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterRest {

  @Bean
  public RouterFunction<ServerResponse> routerFunction(UserHandler userHandler) {
    return nest(path("/api/v1/users"),
        route(POST(""), userHandler::saveUser)
            .andRoute(GET("/{id}"), userHandler::findUserById)
            .andRoute(GET(""), userHandler::findAll)
            .andRoute(PUT("/{id}"), userHandler::updateUser)
            .andRoute(DELETE("/{id}"), userHandler::deleteById)
    );
  }
}

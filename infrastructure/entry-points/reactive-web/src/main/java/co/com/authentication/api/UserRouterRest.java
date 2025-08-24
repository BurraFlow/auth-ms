package co.com.authentication.api;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRouterRest {

  @Bean
  public RouterFunction<ServerResponse> routerFunction(UserHandler userHandler) {
    return route(POST("/api/v1/user"), userHandler::saveUser)
        .andRoute(GET("/api/v1/user/{id}"), userHandler::findUserById)
        .and(route(GET("/api/v1/user/findAll"), userHandler::findAll))
        .and(route(DELETE("/api/v1/user/delete/{id}"), userHandler::deleteById));
  }
}

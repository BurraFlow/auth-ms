package co.com.authentication.api;

import co.com.authentication.api.dto.CreateUserDto;
import co.com.authentication.api.dto.UpdateUserDto;
import co.com.authentication.api.dto.UserDto;
import co.com.authentication.api.mapper.UserDtoMapper;
import co.com.authentication.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHandler {

  private final UserUseCase userUseCase;
  private final UserDtoMapper mapper;

  public Mono<ServerResponse> saveUser(ServerRequest request) {
    return request.bodyToMono(CreateUserDto.class)
        .map(mapper::toModel)
        .flatMap(userUseCase::saveUser)
        .flatMap(savedUser -> ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(savedUser));
  }

  public Mono<ServerResponse> findUserById(ServerRequest request) {
    Long id = Long.valueOf(request.pathVariable("id"));
    return userUseCase.findById(id)
        .map(mapper::toResponse)
        .flatMap(dto -> ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(dto));
  }

  public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(userUseCase.findAll().map(mapper::toResponse), UserDto.class);
  }

  public Mono<ServerResponse> updateUser(ServerRequest request) {
    return Mono.just(request.pathVariable("id"))
        .map(Long::valueOf)
        .onErrorResume(e -> Mono.error(new IllegalArgumentException("Invalid user id")))
        .flatMap(id -> request.bodyToMono(UpdateUserDto.class)
            .map(mapper::toModel)
            .flatMap(user -> userUseCase.updateUser(id, user))
            .flatMap(savedUser -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(savedUser))
            .switchIfEmpty(ServerResponse.notFound().build())
        );
  }


  public Mono<ServerResponse> deleteById(ServerRequest request) {
    Long id = Long.valueOf(request.pathVariable("id"));
    return userUseCase.deleteById(id)
        .then(ServerResponse.noContent().build());
  }

}

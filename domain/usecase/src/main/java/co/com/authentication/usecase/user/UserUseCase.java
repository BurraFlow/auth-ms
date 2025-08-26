package co.com.authentication.usecase.user;

import co.com.authentication.model.user.User;
import co.com.authentication.model.user.gateways.UserRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserUseCase {

  private final UserRepository userRepository;

  public Mono<User> saveUser(User user) {
    if (Objects.nonNull(userRepository.findByEmail(user.getEmail()))) {
      throw new RuntimeException("Ya hay un usuario registrado con este correo");
    }
    return userRepository.saveUser(user);
  }

  public Mono<User> findById(Long id) {
    return userRepository.findById(id);
  }

  public Mono<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public Flux<User> findAll() {
    return userRepository.findAll();
  }

  public Mono<User> updateUser(Long id, User user) {
    return userRepository.update(id, user);
  }

  public Mono<Void> deleteById(Long id) {
    return userRepository.deleteById(id);
  }
}

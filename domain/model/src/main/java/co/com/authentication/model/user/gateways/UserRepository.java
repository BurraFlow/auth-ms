package co.com.authentication.model.user.gateways;

import co.com.authentication.model.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {

  Mono<User> saveUser(User user);
  Mono<User> findById(Long id);
  Mono<User> findByEmail(String email);
  Flux<User> findAll();
  Mono<User> update(Long id,User user);
  Mono<Void> deleteById(Long id);

}

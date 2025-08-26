package co.com.authentication.r2dbc;

import co.com.authentication.model.user.User;
import co.com.authentication.model.user.gateways.UserRepository;
import co.com.authentication.r2dbc.entity.UserEntity;
import co.com.authentication.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Repository
public class UserReactiveRepositoryAdapter extends ReactiveAdapterOperations<
    User/* change for domain model */,
    UserEntity/* change for adapter model */,
    Long,
    UserReactiveRepository
    > implements UserRepository {

  public UserReactiveRepositoryAdapter(UserReactiveRepository repository, ObjectMapper mapper) {
    super(repository, mapper, d -> mapper.map(d, User.class));
  }

  @Transactional(transactionManager = "r2dbcTransactionManager")
  @Override
  public Mono<User> saveUser(User user) {
    return super.saveUser(user);
  }

  @Transactional(transactionManager = "r2dbcTransactionManager")
  @Override
  public Mono<User> findByEmail(String email) {
    return repository.findByEmail(email)
        .map(this::toEntity);
  }

  @Transactional(transactionManager = "r2dbcTransactionManager")
  @Override
  public Mono<User> update(Long id, User user) {
    return null;
  }

  @Transactional(transactionManager = "r2dbcTransactionManager")
  @Override
  public Mono<Void> deleteById(Long id) {
    return repository.deleteById(id);
  }
}

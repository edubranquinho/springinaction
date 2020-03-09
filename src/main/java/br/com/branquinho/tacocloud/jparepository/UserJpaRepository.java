package br.com.branquinho.tacocloud.jparepository;

import br.com.branquinho.tacocloud.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}

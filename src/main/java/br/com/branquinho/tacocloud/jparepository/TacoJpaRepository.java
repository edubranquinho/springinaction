package br.com.branquinho.tacocloud.jparepository;

import br.com.branquinho.tacocloud.model.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoJpaRepository extends CrudRepository<Taco, Long> {
}

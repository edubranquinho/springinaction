package br.com.branquinho.tacocloud.jparepository;

import br.com.branquinho.tacocloud.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderJpaRepository extends CrudRepository<Order, Long> {
}

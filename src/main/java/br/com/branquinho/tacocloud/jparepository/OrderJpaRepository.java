package br.com.branquinho.tacocloud.jparepository;

import br.com.branquinho.tacocloud.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderJpaRepository extends CrudRepository<Order, Long> {

    List<Order> findByPersonName(String personName);

    List<Order> readByZip(String zipCode);

    List<Order> findByPersonNameAndCity(String personName, String siglaDoEstado);

    @Query(value = "SELECT * FROM TACO_ORDER WHERE person_name = ?1 AND city = ?2", nativeQuery = true)
    List<Order> findByPersonNameAndCityNativeQuery(String personName, String siglaEstado);

}

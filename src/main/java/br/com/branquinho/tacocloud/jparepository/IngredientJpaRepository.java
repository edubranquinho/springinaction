package br.com.branquinho.tacocloud.jparepository;

import br.com.branquinho.tacocloud.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientJpaRepository extends CrudRepository<Ingredient, String> {

}

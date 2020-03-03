package br.com.branquinho.tacocloud.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Taco {

    private Long id;
    private LocalDate createdAt;
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
    @Size(min = 1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();

    public void setIngredients(List<String> ingredients) {
        for (String id : ingredients) {
            Ingredient ingredient = new Ingredient();
            ingredient.setId(id);
            this.ingredients.add(ingredient);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taco taco = (Taco) o;
        return Objects.equals(id, taco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

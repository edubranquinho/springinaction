package br.com.branquinho.tacocloud.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "createdat")
    private LocalDate createdAt;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @Size(min = 1, message="You must choose at least 1 ingredient")
    @ManyToMany(targetEntity=Ingredient.class)
    @JoinTable(name="taco_ingredients", joinColumns=
            {@JoinColumn(name="taco_id")}, inverseJoinColumns=
            {@JoinColumn(name="ingredient_id")})
    private List<Ingredient> ingredients = new ArrayList<>();

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

    @PrePersist
    void createdAt() {
        this.createdAt = LocalDate.now();
    }
}

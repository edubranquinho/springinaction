package br.com.branquinho.tacocloud.controller;

import br.com.branquinho.tacocloud.jparepository.IngredientJpaRepository;
import br.com.branquinho.tacocloud.jparepository.TacoJpaRepository;
import br.com.branquinho.tacocloud.model.Order;
import br.com.branquinho.tacocloud.repository.IngredientRepository;
import br.com.branquinho.tacocloud.repository.TacoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import br.com.branquinho.tacocloud.model.Ingredient;
import br.com.branquinho.tacocloud.model.Ingredient.Type;
import br.com.branquinho.tacocloud.model.Taco;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientJpaRepository ingredientRepository;
    private final TacoJpaRepository tacoRepository;

    public DesignTacoController(IngredientJpaRepository ingredientRepository, TacoJpaRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }
    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                               filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }
        Taco saved = tacoRepository.save(design);
        order.addDesign(saved);
        return "redirect:/orders/current";
    }

    private Object filterByType(Iterable<Ingredient> ingredients, Type type) {
        final List<Ingredient> copiaIngredientes = new ArrayList<>();
        ingredients.forEach(copiaIngredientes::add);
        copiaIngredientes.removeIf(ingredient -> ingredient.getType() != type);
        return copiaIngredientes;
    }
}

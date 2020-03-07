package br.com.branquinho.tacocloud.controller;

import br.com.branquinho.tacocloud.jparepository.OrderJpaRepository;
import br.com.branquinho.tacocloud.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private final OrderJpaRepository orderRepository;

    public OrderController(OrderJpaRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm(@ModelAttribute("order") Order order, Model model) {
        model.addAttribute("order", order);
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors erros, SessionStatus sessionStatus) {
            if(erros.hasErrors()) {
            return "orderForm";
        }

        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

}

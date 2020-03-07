package br.com.branquinho.tacocloud.controller;

import br.com.branquinho.tacocloud.jparepository.OrderJpaRepository;
import br.com.branquinho.tacocloud.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import br.com.branquinho.tacocloud.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

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
        if (erros.hasErrors()) {
            return "orderForm";
        }

        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping
    @Transactional
    public String testeDeQueryDsl() throws InterruptedException {
        List<Order> listaDePedidos = orderRepository.findByPersonName("Eduardo");

        Order meuPedido1 = listaDePedidos.get(0);
        System.out.println("meuPedido1 name:" + meuPedido1.getPersonName());

        meuPedido1.setPersonName("Eduardo de Medeiros Branquinho");

        List<Order> listaDePedidosPorZipCode = orderRepository.readByZip("4143020");

        Order meuPedido2 = listaDePedidosPorZipCode.get(0);
        System.out.println("meuPedido2 name:" + meuPedido2.getPersonName());

        List<Order> byPersonNameAndCity = orderRepository.findByPersonNameAndCityNativeQuery("Eduardo", "SP");

        Order meuPedido3 = byPersonNameAndCity.get(0);
        System.out.println("meuPedido3 name:" + meuPedido3.getPersonName());

        return "redirect:/";
    }

}

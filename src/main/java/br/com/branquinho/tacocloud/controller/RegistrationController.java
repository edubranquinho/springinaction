package br.com.branquinho.tacocloud.controller;

import br.com.branquinho.tacocloud.controller.forms.RegistrationForm;
import br.com.branquinho.tacocloud.jparepository.UserJpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserJpaRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserJpaRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userRepository.save(form.toEntity(passwordEncoder));
        return "redirect:/login";
    }
}

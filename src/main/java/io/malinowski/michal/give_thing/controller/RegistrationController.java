package io.malinowski.michal.give_thing.controller;

import io.malinowski.michal.give_thing.domain.model.User;
import io.malinowski.michal.give_thing.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
@Slf4j
public class RegistrationController {
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String prepareRegistration(Model model) {
        log.info("Przygotowanie nowego użytkownika");
        model.addAttribute("register", new User());
        return "registration-form";
    }

    @PostMapping
    public String processRegistrationData(@Valid User user, BindingResult errors) {
        log.debug("Dane do rejestracji: {}", user);
        if (errors.hasErrors()) {
            log.debug("Błędy w danych do rejestracji: {}", errors);
            return "registration-form";
        }
        registrationService.register(user);
        log.debug("Poprawnie zarejestrowano dane: {}", user);
        return "redirect:/login";
    }
}
//model maper - mapowanie dto>encja

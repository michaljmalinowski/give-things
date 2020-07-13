package io.malinowski.michal.give_thing.controller;

import io.malinowski.michal.give_thing.dto.NewDonationDto;
import io.malinowski.michal.give_thing.service.CategoryService;
import io.malinowski.michal.give_thing.service.DonationService;
import io.malinowski.michal.give_thing.service.InstitutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private static final Logger log = LoggerFactory.getLogger(DonationController.class);
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationService donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping("new")
    public String prepareDonationForm(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("data", new NewDonationDto());
        log.info("Przygotowanie danych: {}", model.asMap());
        return "donation-form";
    }

    @PostMapping("new")
    public String processDonationForm(@ModelAttribute("data") @Valid NewDonationDto newDonationDto, BindingResult bindingResult) {
        log.info("donation before save: {}", newDonationDto);
        if (bindingResult.hasErrors()) {
            log.warn("Błędne dane {}", bindingResult.getSuppressedFields());
            return "redirect:/donation/new";
        }
        log.info("Prepare to save: {}", newDonationDto);
        donationService.saveNewDonation(newDonationDto);
        log.info("Saved donation: {}", newDonationDto);
        return "donation-form-confirmation";
    }
}

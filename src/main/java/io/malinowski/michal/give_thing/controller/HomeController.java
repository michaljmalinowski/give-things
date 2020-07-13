package io.malinowski.michal.give_thing.controller;

import io.malinowski.michal.give_thing.domain.dao.InstitutionDao;
import io.malinowski.michal.give_thing.service.DonationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    private final InstitutionDao institutionDao;
    private final DonationService donationService;

    public HomeController(InstitutionDao institutionDao, DonationService donationService) {
        this.institutionDao = institutionDao;
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("institutions", institutionDao.findAll());
        model.addAttribute("countDonation", donationService.countDonation());
        model.addAttribute("countSack", donationService.countSack());
        return "index";
    }
}

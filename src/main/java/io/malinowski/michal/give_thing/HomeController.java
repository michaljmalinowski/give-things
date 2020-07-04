package io.malinowski.michal.give_thing;

import io.malinowski.michal.give_thing.domain.dao.InstitutionDao;
import io.malinowski.michal.give_thing.domain.model.Institution;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class HomeController {
    private final InstitutionDao institutionDao;

    public HomeController(InstitutionDao institutionDao) {
        this.institutionDao = institutionDao;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        List<Institution> institutions = institutionDao.findAll();
        model.addAttribute("institutions", institutions);
        return "index";
    }
}

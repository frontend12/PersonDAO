package ru.stas.springcorse.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.stas.springcorse.controllers.dao.PersonDAO;
import ru.stas.springcorse.controllers.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleConrtoller {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleConrtoller(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people",personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public  String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person",personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "people/new";

    }

    @PostMapping
    public String create(@ModelAttribute("person") Person person){
        personDAO.save(person);
        return "redirect:/people";

    }
}

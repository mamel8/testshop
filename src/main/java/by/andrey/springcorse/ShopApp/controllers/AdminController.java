package by.andrey.springcorse.ShopApp.controllers;

import by.andrey.springcorse.ShopApp.dto.PersonDTO;
import by.andrey.springcorse.ShopApp.models.Person;
import by.andrey.springcorse.ShopApp.services.AdminService;
import by.andrey.springcorse.ShopApp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    private final PersonService personService;

    @Autowired
    public AdminController(AdminService adminService, PersonService personService) {
        this.adminService = adminService;
        this.personService = personService;
    }

    @GetMapping
    public void adminPage(){
        adminService.doAdminStuff();
    }

    @GetMapping("/check")                // ТЕСТ метод
    public List<Person> adminCheck(){                       //TODO
        return adminService.findAll();
    }

    @GetMapping("/check/{id}")                              //TODO
    public PersonDTO getPerson(@PathVariable("id") int id) {
        return personService.convertToPersonDTO(adminService.findById(id));
    }
}
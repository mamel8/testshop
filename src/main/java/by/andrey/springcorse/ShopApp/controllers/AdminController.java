package by.andrey.springcorse.ShopApp.controllers;

import by.andrey.springcorse.ShopApp.dto.PersonDTO;
import by.andrey.springcorse.ShopApp.dto.PersonDtoService;
import by.andrey.springcorse.ShopApp.models.Person;
import by.andrey.springcorse.ShopApp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class  AdminController {

    private final AdminService adminService;

    private final PersonDtoService personDtoService;

    @Autowired
    public AdminController(AdminService adminService, PersonDtoService personDtoService) {
        this.adminService = adminService;
        this.personDtoService = personDtoService;
    }

    @GetMapping
    public void adminPage(){
        adminService.doAdminStuff();
    }

    @GetMapping("/check")                // ТЕСТ метод   --- after DELETE
    public List<PersonDTO> adminCheck(){
        List<PersonDTO> list2 = new ArrayList<>();
        adminService.findAll()
                .stream()
                .map(s->list2.add(personDtoService.convertToPersonDTO(s)))
                .collect(Collectors.toList());
        return list2;
    }

    @GetMapping("/check/{id}")
    public PersonDTO getPerson(@PathVariable("id") int id) {
        return personDtoService.convertToPersonDTO(adminService.findById(id));
    }
}
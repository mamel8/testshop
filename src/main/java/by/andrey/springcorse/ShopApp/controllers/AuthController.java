package by.andrey.springcorse.ShopApp.controllers;

import by.andrey.springcorse.ShopApp.dto.PersonDTO;
import by.andrey.springcorse.ShopApp.models.Person;
import by.andrey.springcorse.ShopApp.repositories.PeopleRepository;
import by.andrey.springcorse.ShopApp.services.AdminService;
import by.andrey.springcorse.ShopApp.services.RegistrationService;
import by.andrey.springcorse.ShopApp.util.PersonErrorResponse;
import by.andrey.springcorse.ShopApp.util.PersonNotCreatedException;
import by.andrey.springcorse.ShopApp.util.PersonNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;

    private final PeopleRepository peopleRepository;

    private final ModelMapper modelMapper;

    private final AdminService adminService;

    @Autowired
    public AuthController(RegistrationService registrationService, PeopleRepository peopleRepository,
                          ModelMapper modelMapper, AdminService adminService) {
        this.registrationService = registrationService;
        this.peopleRepository = peopleRepository;
        this.modelMapper = modelMapper;
        this.adminService = adminService;
    }

    @GetMapping("/check")                // ТЕСТ метод
    public List<Person> adminCheck(){                       //TODO
       return peopleRepository.findAll();
    }

    @GetMapping("/check/{id}")                              //TODO
    public PersonDTO getPerson(@PathVariable("id") int id) {
        return convertToPersonDTO(adminService.findById(id));
    }

    @GetMapping("/login")
    public void loginPage() {
    }

    @GetMapping("/registration")
    public void registrationPage(@ModelAttribute("person") PersonDTO personDTO) {
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid PersonDTO personDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error: errors) {
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append("; ");
            }
            throw new PersonNotCreatedException(errorMsg.toString());
        }
        registrationService.register(convertToPerson(personDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotCreatedException e){
        PersonErrorResponse response = new PersonErrorResponse(e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e){
        PersonErrorResponse response = new PersonErrorResponse("Person with this id was`t found",
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    private Person convertToPerson(PersonDTO personDTO) {
        return modelMapper.map(personDTO, Person.class);
    }

    private PersonDTO convertToPersonDTO(Person person){
        return modelMapper.map(person, PersonDTO.class);
    }
}
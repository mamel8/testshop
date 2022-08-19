package by.andrey.springcorse.ShopApp.controllers;

import by.andrey.springcorse.ShopApp.dto.PersonDTO;
import by.andrey.springcorse.ShopApp.repositories.PeopleRepository;
import by.andrey.springcorse.ShopApp.services.PersonService;
import by.andrey.springcorse.ShopApp.services.RegistrationService;
import by.andrey.springcorse.ShopApp.util.PersonErrorResponse;
import by.andrey.springcorse.ShopApp.util.PersonNotCreatedException;
import by.andrey.springcorse.ShopApp.util.PersonNotFoundException;
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

    private final PersonService personService;


    @Autowired
    public AuthController(RegistrationService registrationService, PersonService personService) {
        this.registrationService = registrationService;
        this.personService = personService;
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
        registrationService.register(personService.convertToPerson(personDTO));
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
}
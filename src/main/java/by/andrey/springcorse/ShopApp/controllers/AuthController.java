package by.andrey.springcorse.ShopApp.controllers;

import by.andrey.springcorse.ShopApp.models.Person;
import by.andrey.springcorse.ShopApp.services.RegistrationService;
import by.andrey.springcorse.ShopApp.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;

    private final ExceptionReg exceptionReg;

    private final ValidatorPerson validatorPerson;

    @Autowired
    public AuthController(RegistrationService registrationService,
                          ExceptionReg exceptionReg, ValidatorPerson validatorPerson) {
        this.registrationService = registrationService;
        this.exceptionReg = exceptionReg;
        this.validatorPerson = validatorPerson;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Person person, BindingResult bindingResult) {
        validatorPerson.validate(person, bindingResult);
        exceptionReg.except(bindingResult);
        registrationService.register(person);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(NotCreatedException e){
        ErrorResponse response = new ErrorResponse(e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(PersonNotFoundException e){
        ErrorResponse response = new ErrorResponse("Person with this id was`t found",
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
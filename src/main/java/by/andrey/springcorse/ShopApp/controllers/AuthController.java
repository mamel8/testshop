package by.andrey.springcorse.ShopApp.controllers;

import by.andrey.springcorse.ShopApp.models.Person;
import by.andrey.springcorse.ShopApp.services.RegistrationService;
import by.andrey.springcorse.ShopApp.util.ErrorResponse;
import by.andrey.springcorse.ShopApp.util.NotCreatedException;
import by.andrey.springcorse.ShopApp.util.PersonNotFoundException;
import by.andrey.springcorse.ShopApp.util.ValidatorPerson;
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
public class  AuthController {

    private final RegistrationService registrationService;
    private final ValidatorPerson validatorPerson;

    @Autowired
    public AuthController(RegistrationService registrationService, ValidatorPerson validatorPerson) {
        this.registrationService = registrationService;
        this.validatorPerson = validatorPerson;
    }


    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Person person, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error: errors) {
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append("; ");
            }
            throw new NotCreatedException(errorMsg.toString());
        }
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
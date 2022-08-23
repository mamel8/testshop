package by.andrey.springcorse.ShopApp.util;

import by.andrey.springcorse.ShopApp.models.Person;
import by.andrey.springcorse.ShopApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidatorPerson implements Validator {

    private final PeopleRepository peopleRepository;

    @Autowired
    public ValidatorPerson(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;


        if(peopleRepository.findByName(person.getName()).isPresent())
            errors.rejectValue("name", "Name is Busy");
        if(peopleRepository.findByEmail(person.getEmail()).isPresent())
            errors.rejectValue("email", "email is Busy");
    }
}

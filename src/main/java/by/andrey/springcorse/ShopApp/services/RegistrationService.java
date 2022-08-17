package by.andrey.springcorse.ShopApp.services;

import by.andrey.springcorse.ShopApp.models.Person;
import by.andrey.springcorse.ShopApp.models.PersonRole;
import by.andrey.springcorse.ShopApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RegistrationService {
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public RegistrationService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public void register(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole(PersonRole.USER);
        person.setRegistration(LocalDateTime.now());
        peopleRepository.save(person);
    }

}

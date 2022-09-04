package by.andrey.springcorse.ShopApp.services;

import by.andrey.springcorse.ShopApp.models.Person;
import by.andrey.springcorse.ShopApp.models.PersonRole;
import by.andrey.springcorse.ShopApp.models.Product;
import by.andrey.springcorse.ShopApp.repositories.PeopleRepository;
import by.andrey.springcorse.ShopApp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;


import java.time.LocalDateTime;

@Service
public class RegistrationService {
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProductRepository productRepository;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder, ProductRepository productRepository) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
        this.productRepository = productRepository;
    }

    @Transactional
    public void register(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole(PersonRole.USER);
        person.setRegistration(LocalDateTime.now());

            peopleRepository.save(person);


    }

    public void addProduct(Product product) {
        product.setCreationDate(LocalDateTime.now());
        productRepository.save(product);
    }
}
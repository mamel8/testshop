package by.andrey.springcorse.ShopApp.services;

import by.andrey.springcorse.ShopApp.models.Person;
import by.andrey.springcorse.ShopApp.repositories.PeopleRepository;
import by.andrey.springcorse.ShopApp.util.PersonNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final PeopleRepository peopleRepository;

    public AdminService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")           // ТЕСТ МЕТОД -------after DELETE
    public void doAdminStuff(){
        System.out.println("Only admin here");
    }

 //   @PreAuthorize("hasRole('ADMIN')")
    public Person findById(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElseThrow(PersonNotFoundException::new);
    }

 //   @PreAuthorize("hasRole('ADMIN')")
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }
}

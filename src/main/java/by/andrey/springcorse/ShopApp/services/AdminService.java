package by.andrey.springcorse.ShopApp.services;

import by.andrey.springcorse.ShopApp.models.Person;
import by.andrey.springcorse.ShopApp.repositories.PeopleRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final PeopleRepository peopleRepository;

    public AdminService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void doAdminStuff(){
        System.out.println("Only admin here");
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<Person> checkAllUsers() {
        return peopleRepository.findAll();
    }
}

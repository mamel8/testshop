package by.andrey.springcorse.ShopApp.services;

import by.andrey.springcorse.ShopApp.dto.PersonDTO;
import by.andrey.springcorse.ShopApp.models.Person;
import by.andrey.springcorse.ShopApp.repositories.PeopleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PeopleRepository peopleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PersonService(PeopleRepository peopleRepository, ModelMapper modelMapper) {
        this.peopleRepository = peopleRepository;
        this.modelMapper = modelMapper;
    }

    public Person convertToPerson(PersonDTO personDTO) {
        return modelMapper.map(personDTO, Person.class);
    }

    public PersonDTO convertToPersonDTO(Person person){
        return modelMapper.map(person, PersonDTO.class);
    }


}

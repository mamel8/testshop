package by.andrey.springcorse.ShopApp.repositories;

import by.andrey.springcorse.ShopApp.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByName (String name);

    Optional<Person> findByNameOrEmail(String name, String email);

    Optional<Object> findByEmail(String email);

    //   boolean existsByNameOrEmail(String name, String email);
}

package com.example.demo.service;

import com.example.demo.models.Person;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private final List<Person> people = new ArrayList<>();

    public List<Person> getPeople() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public Person findById(Long id) {
        return people.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Person jsonPerson() {
        return new Person(1234567890L, "Annette", "Appel", 43);
    }

    public String greeting() {
        return "Hello World!";
    }


}

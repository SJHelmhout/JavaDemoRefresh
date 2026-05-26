package com.example.demo;

import com.example.demo.models.Person;
import com.example.demo.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Demo1Application {
    private final PersonService personService;

    public Demo1Application(PersonService personService){
        this.personService = personService;
    }

    @RequestMapping("/")
    String home () {
        return this.personService.greeting();
    }

    @RequestMapping("/jsonPerson")
    public Person personalia() {
        return this.personService.jsonPerson();
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}

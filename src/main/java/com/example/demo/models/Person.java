package com.example.demo.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private String lastName;
    @Setter(AccessLevel.PACKAGE) private int age;
}

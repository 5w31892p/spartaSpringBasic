package com.sparta.homewokrweek01.models;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PersonRequestDto {
    private String name;
    private int age;
    private String address;

    public PersonRequestDto (String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

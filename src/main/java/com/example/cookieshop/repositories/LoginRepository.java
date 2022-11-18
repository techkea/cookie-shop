package com.example.cookieshop.repositories;

import com.example.cookieshop.models.Person;

import java.util.ArrayList;
import java.util.List;

public class LoginRepository {

    private List<Person> users = new ArrayList<>();

    public int loggedin(Person p){

        users.add(new Person(1, "clbo", "1234"));
        users.add(new Person(2, "benjamin", "1234"));
        for (Person i: users) {
            if (p.getUsername().equals(i.getUsername()) && p.getPassword().equals(i.getPassword()) ){
                return i.getId();
            }
        }
        return -1;

    }


}

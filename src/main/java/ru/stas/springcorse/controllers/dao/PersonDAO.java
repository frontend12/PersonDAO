package ru.stas.springcorse.controllers.dao;

import ru.stas.springcorse.controllers.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();


        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Coc"));
        people.add(new Person(++PEOPLE_COUNT, "Maik"));
        people.add(new Person(++PEOPLE_COUNT,"Karl"));
    }
}

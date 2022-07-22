package ru.stas.springcorse.controllers.dao;

import org.springframework.stereotype.Component;
import ru.stas.springcorse.controllers.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();


        people.add(new Person(++PEOPLE_COUNT, "Tom",24,"tomchik@yohoo.com"));
        people.add(new Person(++PEOPLE_COUNT, "Coc",25,"gogblank@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Maik",34,"adrenolin@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Karl",44,"syperman@mail.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);

    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void updata(int id, Person updatedperson){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedperson.getName());
        personToBeUpdated.setAge(updatedperson.getAge());
        personToBeUpdated.setEmail(updatedperson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p ->  p.getId() == id);
    }
}

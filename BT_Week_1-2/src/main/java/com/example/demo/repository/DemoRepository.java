package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DemoRepository {
    List<Person> listPerson = new ArrayList<Person>();

    @PostConstruct
    public void init(){
        listPerson.add(new Person("Person1", "A", 21, "football"));
        listPerson.add(new Person("Person2", "B", 22, "travel"));
        listPerson.add(new Person("Person3", "C", 24, "sing"));
        listPerson.add(new Person("Person4", "D", 26, "volleyball"));
        listPerson.add(new Person("Person5", "E", 30, "basketball"));

    }

    public List<Person> findAll(){
        return listPerson;
    }

    public Person findById(String id){
        for (Person element : listPerson) {
            if (id.equals(element.getId())) {
                return new Person(element.getId(),
                        element.getName(),
                        element.getAge(),
                        element.getHobby());
            }
        }
        return null;
    }
}

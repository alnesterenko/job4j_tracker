package ru.job4j.search;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person onePersone : persons) {
            if (onePersone.getName().contains(key) || onePersone.getSurname().contains(key)
                    || onePersone.getPhone().contains(key) || onePersone.getAddress().contains(key)) {
                result.add(onePersone);
            }
        }
        return result;
    }
}
package model;

import java.util.ArrayList;

public class PersonContainer {
    private ArrayList<Person> persons;
    
    private static PersonContainer instance = new PersonContainer();
    
    private PersonContainer() {
        persons = new ArrayList<>();
    }
    
    public PersonContainer getInstance() {
        return instance;
    }

    public boolean addPerson(Person person) {
        boolean result = false;
        if(person != null) {
            result = persons.add(person);
        }
        return result;
    }
    
    public boolean removePerson(Person person) {
        boolean result = false;
        if(person != null) {
            persons.remove(person);
        }
        return result;
    }
    
    public ArrayList<Person> getAllPersons() {
        if(!persons.isEmpty()) {
            return persons;
        }
        return null;
    }
}

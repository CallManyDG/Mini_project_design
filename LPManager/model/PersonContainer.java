package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is used to represent the container used to store the person's information
 * Used to access all persons and to get filtered list when needed
 * 
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 27 October 2020
 */
public class PersonContainer {
    private ArrayList<Person> persons;

    private static PersonContainer instance = new PersonContainer();

    private PersonContainer() {
        persons = new ArrayList<>();
    }

    public static PersonContainer getInstance() {
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
        return persons;
    }

    public Person findPersonByPhone(String phone) {
        Person personToReturn = null;
        if(phone != null) {
            Iterator<Person> searcher = persons.iterator();
            boolean searching = true;
            while(searcher.hasNext() && searching) {
                Person currentPerson = searcher.next();
                if(currentPerson.getPhone().equals(phone)) {
                    personToReturn = currentPerson;
                    searching = false;
                }
            }
        }
        return personToReturn;
    }
}

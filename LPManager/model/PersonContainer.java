package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is used to represent the container (Singleton) used to store the person information
 * Used to access all persons and to get filtered list when needed
 * 
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 27 October 2020
 */
public class PersonContainer {
    //Fields of the class
    private ArrayList<Person> persons;

    //A static variable representing the instance of this Singleton class
    private static PersonContainer instance = new PersonContainer();

    /**
     *  Constructor for the instance of the class
     */
    private PersonContainer() {
        persons = new ArrayList<>();
    }

    /**
     *  A method to access the instance of the class
     */
    public static PersonContainer getInstance() {
        return instance;
    }
    
    /**
     *  A method to add a person to the container
     *  returns true if the operation was successful
     */
    public boolean addPerson(Person person) {
        boolean result = false;
        if(person != null) {
            result = persons.add(person);
        }
        return result;
    }

    /**
     *  A method to remove a person from the container
     *  returns true if the operation was successful
     */
    public boolean removePerson(Person person) {
        boolean result = false;
        if(person != null) {
            persons.remove(person);
        }
        return result;
    }

    /**
     *  Accessor method used to get all persons in the container
     */
    public ArrayList<Person> getAllPersons() {
        return persons;
    }

    /**
     *  A method to find a specific person by phone
     *  returns the found person or null if it didn't find any
     */
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

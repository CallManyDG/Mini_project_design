package tui;

import control.*;
import model.*;

public class TryMe
{
    
    public void tryMe() {
        fillContainers();
        System.out.println("Done...");
    }
    
    private void fillContainers() {
        System.out.println("Generating Dummy Data!");
        fillPersonContainer();
        fillLPContainer();
    }
    
    private void fillPersonContainer() {
        PersonContainer container = PersonContainer.getInstance();
        container.addPerson(new Person("Alex", "st. Nibevej 12", "9200", "Aalborg", "000000000"));
        container.addPerson(new Person("Dan", "st. Awesome 6", "9200", "Aalborg", "000000111"));
        container.addPerson(new Person("Adam", "st. Nibevej 12", "9200", "Aalborg", "000111000"));
        container.addPerson(new Person("Denisa", "st. Nibevej 12", "9200", "Aalborg", "000111111"));
        container.addPerson(new Person("Nikol", "st. Sunshine 14", "9200", "Aalborg", "111000000"));
    }
    
    private void fillLPContainer() {
        
    }
}

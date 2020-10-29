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
        LPContainer lpCon = LPContainer.getInstance();
        
        LP lp1 = new LP("Harry Potter", "JK Rowling", "14.1.2020");
        Copy cp1 = new Copy(123456);
        lpCon.addLP(lp1);
        
        LP lp2 = new LP("Hobbit", "John R.R. Tolkien", "14.1.2020");
        Copy cp2 = new Copy(1262345);
        cp2.setAvailable(false);
        lp2.addCopy(cp2);
        lpCon.addLP(lp2);
        
        LP lp3 = new LP("LOTR", "John R.R. Tolkien", "14.1.2020");
        Copy cp3 = new Copy(153453);
        lp3.addCopy(cp3);
        lpCon.addLP(lp3);
        
        LP lp4 = new LP("LOTR 2", "John R.R. Tolkien", "14.1.2020");
        Copy cp4 = new Copy(1234563);
        cp4.setAvailable(true);
        lp4.addCopy(cp4);
        lpCon.addLP(lp4);
        
        LP lp5 = new LP("LOTR 3", "John R.R. Tolkien", "14.1.2020");
        Copy cp5 = new Copy(1232185);
        cp5.setAvailable(false);
        lp5.addCopy(cp5);
        lpCon.addLP(lp5);
    }
}

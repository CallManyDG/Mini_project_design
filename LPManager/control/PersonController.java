package control;

import model.*;
import java.util.Iterator;

/**
 * Controller for the person. Bridges the gap between UI and Model layers
 * Used to create person and access information from the model layer
 * 
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 28 October 2020
 */
public class PersonController {
    /**
     *  Gets a person with specified phone from the Person Container
     */
    public Person findPersonByPhone(String phone) {
        return PersonContainer.getInstance().findPersonByPhone(phone);
    }
    
    /**
     *  Adds a loan to the list of loans of a person
     */
    public boolean addLoanToPerson(Loan loan, Person person)
    {
        return person.addLoan(loan);
    }
}
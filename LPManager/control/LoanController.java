package control;

import model.*;
import java.util.ArrayList;

/**
 * Controller for the loans. Bridges the gap between UI and Model layers
 * Used to create loans and access information from the model layer
 * 
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 28 October 2020
 */
public class LoanController {
    //Fields of the class
    private PersonController personCon;
    private LPController lpCon;

    /**
     * Constructor for objects of this controller
     */
    public LoanController() {
        personCon = new PersonController();
        lpCon = new LPController();
    }
    
    /**
     *  A method used to create a loan using a date and list of copies. Asign to a person found by given phone number
     *  returns true if the action was successful
     */
    public boolean createLoan(String agreedReturnDate, ArrayList<Copy> copies, String phone) {
        boolean result = false;
        // Call loan constructor
        Loan loan = new Loan(agreedReturnDate, copies);
        // find person by phone
        Person person = personCon.findPersonByPhone(phone);
        //Add loan to the container
        LoanContainer.getInstance().addLoan(loan);
        // Assing loan to person
        if(person != null) {
            result = personCon.addLoanToPerson(loan, person);
        }
        return result;
    }
    
    /**
     *  Gets a copy by title and author from the LP Controller
     */
    public Copy getCopy(String title, String author) {
        return lpCon.findFirstAvailableCopy(title, author);
    }
    
    /**
     *  Gets a person by phone from the Person Controller
     */
    public Person getPerson(String phone) {
        return personCon.findPersonByPhone(phone);
    }
}
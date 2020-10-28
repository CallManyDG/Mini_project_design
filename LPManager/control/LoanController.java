package control;

import model.*;
import java.util.ArrayList;

public class LoanController {
 
    private PersonController personCon;
    private LPController lpCon;

    public LoanController() {
        personCon = new PersonController();
        lpCon = new LPController();
    }
    
    public boolean createLoan(String agreedReturnDate, ArrayList<Copy> copies, String phone) {
        boolean result = false;
        // find person by phone
        Person person = personCon.findPersonByPhone(phone);
        // Call loan constructor
        Loan loan = new Loan(agreedReturnDate, copies);
        // Assing loan to person
        if(person != null) {
            result = personCon.addLoanToPerson(loan, person);
        }
        return result;
    }
    
    public Copy getCopy(String title, String author) {
        return lpCon.findFirstAvailableCopy(title, author);
    }
}
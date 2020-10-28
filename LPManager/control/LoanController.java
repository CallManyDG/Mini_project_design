package control;

import model.*;
import java.util.ArrayList;

public class LoanController {
 
    private PersonController peronCon;
    private LPController lpCon;

    public LoanController() {
        peronCon = new PersonController();
        lpCon = new LPController();
    }
    
    public boolean createLoan(String agreedReturnDate, ArrayList<Copy> copies, String phone) {
        boolean result = false;
        // find person by phone
        // Call loan constructor
        // assing loan to person
        return result;
    }
    
    public Copy getCopy(String title, String author) {
        return lpCon.findFirstAvailableCopy(title, author);
    }
}
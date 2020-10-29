package control;

import model.*;
import java.util.Iterator;

public class PersonController {

    public Person findPersonByPhone(String phone) {
        return PersonContainer.getInstance().findPersonByPhone(phone);
    }
    
    public boolean addLoanToPerson(Loan loan, Person person)
    {
        return person.addLoan(loan);
    }
}
package control;

import model.*;
import java.util.Iterator;

public class PersonController {

    public Person findPersonByPhone(String phone) {
        Person personToReturn = null;
        if(phone != null) {
            Iterator<Person> searcher = PersonContainer.getInstance().getAllPersons().iterator();
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
    
    public boolean addLoanToPerson(Loan loan, Person person)
    {
        return person.addLoan(loan);
    }
}
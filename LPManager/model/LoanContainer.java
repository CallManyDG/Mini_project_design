package model;

import java.util.ArrayList;

/**
 * This class is used to represent the container (Singleton) used to store the loan information
 * Used to access all loans
 * 
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 27 October 2020
 */
public class LoanContainer {
    //Fields of the class
    private ArrayList<Loan> loans;
    
    //A static variable representing the instance of this Singleton class
    private static LoanContainer instance = new LoanContainer();
    
    /**
     *  Constructor for the instance of the class
     */
    private LoanContainer() {
        loans = new ArrayList<>();
    }
    
    /**
     *  A method to access the instance of the class
     */
    public static LoanContainer getInstance() {
        return instance;
    }

    /**
     *  A method to add a loan to the container
     *  returns true if the operation was successful
     */
    public boolean addLoan(Loan loan) {
        boolean result = false;
        if(loan != null) {
            result = loans.add(loan);
        }
        return result;
    }
    
    /**
     *  A method to remove a loan from the container
     *  returns true if the operation was successful
     */
    public boolean removeLoan(Loan loan) {
        boolean result = false;
        if(loan != null) {
            loans.remove(loan);
        }
        return result;
    }
    
    /**
     *  Accessor method used to get all persons in the container
     */
    public ArrayList<Loan> getAllLoans() {
        return loans;
    }
}
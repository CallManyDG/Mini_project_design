package model;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * This class is used to represent a loan with borrow date, agreed return date and the an actual return date.
 * A loan also has a list of copies. Includes all needed accessors and mutators
 * 
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 27 October 2020
 */
public class Loan {
    //Fields of the class
    private int loanID;
    private String borrowDate;
    private String returnDate;
    private String agreedReturnDate;
    private ArrayList<Copy> copies;
    
    //Static variable which increments every time a new loan is created. Used as a unique ID
    private static int uniqueID = 0;
    
    /**
     * Constructor for objects of class Loan
     */
    public Loan(String agreedReturnDate, ArrayList<Copy> copies) {
        this.loanID = ++uniqueID;
        this.borrowDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        this.agreedReturnDate = agreedReturnDate;
        this.copies = copies;
    }
    
    /**
     *  Accessors for the loanID, borrowDate, returnDate, agreedReturnDate, and copies
     */
    public int getLoanID() {
        return loanID;
    }
    
    public String getBorrowDate() {
        return borrowDate;
    }
    
    public String getReturnDate() {
        return returnDate;
    }
    
    public String getAgreedReturnDate() {
        return agreedReturnDate;
    }
    
    public ArrayList<Copy> getCopies() {
        return copies;
    }

    /**
     *  Mutators for the loanID, borrowDate, returnDate, agreedReturnDate, and copies
     */
    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }
    
    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }
    
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    
    public void setAgreedReturnDate(String agreedReturnDate) {
        this.agreedReturnDate = agreedReturnDate;
    }
    
    public void setCopies(ArrayList<Copy> copies) {
        this.copies = copies;
    }
    
    /**
     *  Add a copy to the copy list
     */
    public void addCopy(Copy copy) {
        if(copy != null) {
            copies.add(copy);
        }
    }
    
    /**
     *  Remove a copy fom the copy list
     */
    public void removeCopy(Copy copy) {
        if(copy != null) {
            copies.remove(copy);
        }
    }
}
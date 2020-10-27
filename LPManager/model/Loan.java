package model;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Loan {
    private int loanID;
    private String borrowDate;
    private String returnDate;
    private String agreedReturnDate;
    private ArrayList<Copy> copies;
    
    private static int uniqueID = 0;
    
    public Loan(String borrowDate, String agreedReturnDate, ArrayList<Copy> copies) {
        this.loanID = ++uniqueID;
        this.borrowDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        this.agreedReturnDate = agreedReturnDate;
        this.copies = copies;
    }
    
    /**
     * Get the unique loan ID
     */
    public int getLoanID() {
        return loanID;
    }
    
    /**
     * Get the borrow date
     */
    public String getBorrowDate() {
        return borrowDate;
    }
    
    /**
     * Get the return date
     */
    public String getReturnDate() {
        return returnDate;
    }
    
    /**
     * Get the agreed return date
     */
    public String getAgreedReturnDate() {
        return agreedReturnDate;
    }

    /**
     * Set the loan id
     */
    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }
    
    /**
     * Set the borrow date
     */
    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }
    
    /**
     * Set the return date
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    
    /**
     * Set the agreed return date
     */
    public void setAgreedReturnDate(String agreedReturnDate) {
        this.agreedReturnDate = agreedReturnDate;
    }
    
    /**
     *  Add a copy
     */
    public void addCopy(Copy copy) {
        if(copy != null) {
            copies.add(copy);
        }
    }
    
    /**
     *  Remove a copy
     */
    public void removeCopy(Copy copy) {
        if(copy != null) {
            copies.remove(copy);
        }
    }
}
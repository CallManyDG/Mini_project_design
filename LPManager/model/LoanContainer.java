package model;

import java.util.ArrayList;

public class LoanContainer {
    private ArrayList<Loan> loans;
    
    private static LoanContainer instance = new LoanContainer();
    
    private LoanContainer() {
        loans = new ArrayList<>();
    }
    
    public static LoanContainer getInstance() {
        return instance;
    }

    public boolean addLoan(Loan loan) {
        boolean result = false;
        if(loan != null) {
            result = loans.add(loan);
        }
        return result;
    }
    
    public boolean removeLoan(Loan loan) {
        boolean result = false;
        if(loan != null) {
            loans.remove(loan);
        }
        return result;
    }
    
    public ArrayList<Loan> getAllLoans() {
        if(!loans.isEmpty()) {
            return loans;
        }
        return null;
    }
}
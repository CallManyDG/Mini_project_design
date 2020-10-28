package tui;

import control.*;
import model.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Write a description of class LoanMenu here.
 *
 * @author Denisa
 * @version 26 oct. 2020
 */
public class LoanMenu
{
    private LoanController loanControl;
    
    public LoanMenu() {
        
    }

    public void start () {
        loanMenu();
    }

    private void loanMenu() {
        boolean running = true;
        while (running) {
            int choice = writeLoanMenu();
            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    createLoan();
                    break;
                default:
                    System.out.println ("Wrong choice");
                    break;
            }

        }
    }

    private boolean createLoan() {
        boolean result = false;
        String agreedReturnDate, phone, title, author;
        ArrayList<Copy> copies;
        //TODO User input for date, phone, title, and author
        loanControl.createLoan(agreedReturnDate, copies, phone);
        return result;
    }
    
    private int writeLoanMenu () {
        Scanner keyboard = new Scanner (System.in);
        System.out.println ("*****Loan menu*****");
        System.out.println ("(1) Create a loan");
        System.out.println ("(0) Go back");
        System.out.println ("Select: ");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }

    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input must be a number! Try again.");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
}

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
        loanControl = new LoanController();
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
        Scanner keyboard = new Scanner(System.in);
        
        System.out.printf("Enter a phone number to find a person...%n>");
        String phone = keyboard.nextLine();
        System.out.printf("Enter an agreed return date for the copy...%n>");
        String agreedReturnDate = keyboard.nextLine();
        ArrayList<Copy> copies = getCopies();
        
        if(copies == null || copies.isEmpty()) {
            System.out.println("No copies specified... cancelling loan creation.");
        } else {
            //TODO User input for date, phone, title, and author
            result = loanControl.createLoan(agreedReturnDate, copies, phone);
        }
        return result;
    }
    
    private ArrayList<Copy> getCopies() {
        ArrayList<Copy> copiesToReturn = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        boolean running = true;
        while(running) {
            switch(printCopyLoanMenu()) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.printf("Enter a title...%n>");
                    String title = keyboard.nextLine();
                    System.out.printf("Enter an author...%n>");
                    String author = keyboard.nextLine();
                    Copy copy = loanControl.getCopy(title, author);
                    if (copy != null) {
                        copiesToReturn.add(copy);
                    } else {
                        System.out.printf("The copy by title %s and author %s was not found!%nTry again.%n%n", title, author);
                    }
            }
        }
        return copiesToReturn;
    }
    
    private int printCopyLoanMenu() {
        Scanner keyboard = new Scanner (System.in);
        System.out.println ("*****Add Copy*****");
        System.out.println ("(1) Add copy");
        System.out.println ("(0) Exit");
        System.out.println ("Select: ");
        int choice = getIntegerFromUser(keyboard);
        return choice;
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

package tui;

import control.*;
import model.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The Loan menu UI giving different options to manage loans
 *
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 27 October 2020
 */
public class LoanMenu {
    //Fields of the class
    private LoanController loanControl;
    
    /**
     * Constructor for objects of LoanMenu
     */
    public LoanMenu() {
        loanControl = new LoanController();
    }

    /**
     * Method to start the loan menu
     */
    public void start () {
        loanMenu();
    }

    /**
     * A method to show the user options and get their input
     */
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

    /**
     * A method to get the user input and call the controller to create a loan
     */
    private boolean createLoan() {
        boolean result = false;
        Scanner keyboard = new Scanner(System.in);
        
        String phone;
        String message = "Enter a phone number to find a person...%n> "; //Show this message the 1st time
        do { //Ask for a phone until it finds a person or the user exits
            System.out.printf(message);
            phone = keyboard.nextLine();
            if(phone.equalsIgnoreCase("exit")) { //Stop if the user wats to exit
                return false;
            }
            message = "Person with phone \"" + phone + "\" was not found! Try again or type \"exit\"...%n> "; //Set the message to an error after the 1st time
        } while(loanControl.getPerson(phone) == null);
        System.out.println("Proceed creating a loan for " + loanControl.getPerson(phone).getName());
        
        System.out.printf("Enter an agreed return date for the copy...%n> ");
        String agreedReturnDate = keyboard.nextLine();
        ArrayList<Copy> copies = getCopies();
        
        if(copies == null || copies.isEmpty()) { //Create if all is set
            System.out.println("No copies specified... cancelling loan creation.");
        } else {
            if(loanControl.createLoan(agreedReturnDate, copies, phone)) {
                System.out.println("Successfuly created the loan.");
            } else {
                System.out.printf("Something wen't horribly wrong...", phone);
            }
        }
        return result;
    }
    
    /**
     *  A method to get the user input on what copies to add to the loan
     *  returns the chosen copies
     */
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
                    System.out.printf("Enter a title...%n> ");
                    String title = keyboard.nextLine();
                    System.out.printf("Enter an author...%n> ");
                    String author = keyboard.nextLine();
                    Copy copy = loanControl.getCopy(title, author);
                    if (copy != null) {
                        System.out.printf("Added %s by %s to the copies to loan%n", title, author);
                        copiesToReturn.add(copy);
                    } else {
                        System.out.printf("The copy by title %s and author %s was not found!%nTry again.%n%n", title, author);
                    }
            }
        }
        return copiesToReturn;
    }
    
    /**
     * A method to print the user options on adding copies and get an input
     */
    private int printCopyLoanMenu() {
        Scanner keyboard = new Scanner (System.in);
        System.out.println ("*****Add Copy*****");
        System.out.println ("(1) Add copy");
        System.out.println ("(0) Finish Loan Creation");
        System.out.println ("Select: ");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }
    
    /**
     * A method to print the user options on the loan menu and get an input
     */
    private int writeLoanMenu () {
        Scanner keyboard = new Scanner (System.in);
        System.out.println ("*****Loan menu*****");
        System.out.println ("(1) Create a loan");
        System.out.println ("(0) Go back");
        System.out.println ("Select: ");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }
    
    /**
     * A method to get an integer from the user
     */
    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input must be a number! Try again.");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
}

package tui;

import java.util.*;
import control.*;

/**
 * The LP menu UI giving different options to manage LPs
 *
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 28 October 2020
 */
public class LPMenu {
    //Fields of the class
    private LPController lpControl;
    
    /**
     * Constructor for objects of LPMenu
     */
    public LPMenu () {
        lpControl = new LPController();
    }

    /**
     * Method to start the LP menu
     */
    public void start() {
        LPmenu();
    }

    /**
     * A method to show the user options and get their input
     */
    private void LPmenu() {
        boolean running = true;
        while (running) {
            int choice = writeLPMenu();
            switch (choice) {
                case 0:
                running = false;
                break;
                case 1:
                createLP();
                break;
                case 2:
                addCopyForLP();
                break;
                default:
                System.out.println ("Wrong choice");
                break;
            }

        }
    }

    /**
     * A method to get the user input and call the controller to create a LP
     */
    private boolean createLP() {
        boolean result = false;
        Scanner keyboard = new Scanner(System.in);

        System.out.printf("Enter a title...%n> ");
        String title = keyboard.nextLine();
        System.out.printf("Enter an author...%n> ");
        String author = keyboard.nextLine();
        System.out.printf("Enter a publication date...%n> ");
        String publicationDate = keyboard.nextLine();

        if(lpControl.createLP(title, author, publicationDate)) {
            System.out.printf("Successfuly created the LP with title %s and author %s!%n", title, author);
        } else {
            System.out.printf("Failed to create LP, already exists? \"%s\" by %s!%n", title, author);
        }
        return result;
    }

    /**
     * A method to add a copy to a specified by user input LP
     */
    private boolean addCopyForLP() {
        boolean result = false;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.printf("Enter a title...%n> ");
        String title = keyboard.nextLine();
        System.out.printf("Enter an author...%n> ");
        String author = keyboard.nextLine();
        
        System.out.printf("Enter an serial number for the copy...%n> ");
        int serialNumber = getIntegerFromUser(keyboard);
        
        if(lpControl.addLPCopy(title, author, serialNumber)) { //If the action was successful
            System.out.printf("Successfuly added copy for LP with title %s and author %s!%n", title, author);
        } else { //If not the LP doesn't exist or it's a duplicate
            System.out.printf("Failed to add a copy to LP \"%s\" by %s!.%nLP doesn't exist or serial number \"%d\" is duplicate.%n%n", title, author, serialNumber);
        }
        
        return result;
    }
    
    /**
     * A method to print the user options on the LP menu and get an input
     */
    private int writeLPMenu () {
        Scanner keyboard = new Scanner (System.in);
        System.out.println ("*****LP menu*****");
        System.out.println ("(1) Add LP");
        System.out.println ("(2) Add Copy to LP");
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

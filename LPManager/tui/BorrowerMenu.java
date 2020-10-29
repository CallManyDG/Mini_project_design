package tui;
import java.util.*;

/**
 * The Person menu UI giving different options to manage LPs
 *
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 28 October 2020
 */
public class BorrowerMenu
{
    /**
     * Default public constructor
     */
    public BorrowerMenu (){
    }

    /**
     * Method to start the Person menu
     */
    public void start () {
        borrowerMenu();
    }

    /**
     * A method to show the user options and get their input
     */
    private void borrowerMenu() {
        boolean running = true;
        while (running) {
            int choice = writeBorrowerMenu();
            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.println ("??// Option 1");
                    break;
                case 2:
                    System.out.println ("??// Option 2");
                    break;
                default:
                    System.out.println ("Wrong choice");
                    break;
            }
        }
    }

    /**
     * A method to print the user options on the Person menu and get an input
     */
    private int writeBorrowerMenu() {
        Scanner keyboard = new Scanner (System.in);
        System.out.println ("*****Borrower menu*****");
        System.out.println ("(1) ??");
        System.out.println ("(2) ??");
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

package tui;

import java.util.*;
import control.*;

public class LPMenu
{
    private LPController lpControl;
    
    public LPMenu () {
        lpControl = new LPController();
    }

    public void start() {
        LPmenu();
    }

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
                System.out.println ("??// Option 2");
                break;
                default:
                System.out.println ("Wrong choice");
                break;
            }

        }
    }

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

    private int writeLPMenu () {
        Scanner keyboard = new Scanner (System.in);
        System.out.println ("*****LP menu*****");
        System.out.println ("(1) Add LP");
        System.out.println ("(2) ???");
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

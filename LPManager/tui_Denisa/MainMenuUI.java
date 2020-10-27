package tui;
import java.util.Scanner;


/**
 * Write a description of class MainMenuUI here.
 *
 * @author Denisa
 * @version 26 oct. 2020
 */
public class MainMenuUI
{
    private LoanMenu loanMenu;
    private BorrowerMenu borrowerMenu;
    private LPMenu lpMenu;
    
    public MainMenuUI () 
    {
        loanMenu = new LoanMenu();
        borrowerMenu = new BorrowerMenu();
        lpMenu = new LPMenu();
    }
    
    
    public void start () 
    {
        mainMenu();
    }
    
    public void mainMenu ()
    {
        boolean running = true;
        while (running) {
            int choice = writeMainMenu();
            switch (choice) {
                case 0:
                    writeEnd();
                    running = false;
                    break;
                case 1:
                    borrowerMenu.start();
                    break;
                case 2:
                    lpMenu.start();
                    break;
                case 3:
                    loanMenu.start();
                    break;
                case 9:
                    System.out.println ("NOT IMPLEMENTED YET// Generate testdata");
                    break;
                default:
                    System.out.println ("An unexpected error occured with choice: " +choice);
                    break;
            }
        }
    }
    
    private int writeMainMenu () 
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println ("******Main menu******");
        System.out.println("(1) Borrower menu");
        System.out.println("(2) LP menu");
        System.out.println("(3) Loan menu");
        System.out.println("(9) Generate testdata");
        System.out.println("(0) Quit the program");
        while (!keyboard.hasNextInt()) {
            System.out.println("The input must be a number! Try again...");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
    }
    
    public void writeEnd () 
    {
        System.out.println ("Thank you for using the program.");
    }
}

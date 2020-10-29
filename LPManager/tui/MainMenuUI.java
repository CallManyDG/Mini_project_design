package tui;
import java.util.Scanner;

/**
 * The Main menu displayed in the UI. Provides access to the different options the user has
 *
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 27 October 2020
 */
public class MainMenuUI {
    //Fields of the class
    private LoanMenu loanMenu;
    private BorrowerMenu borrowerMenu;
    private LPMenu lpMenu;
    private TryMe tryMe = new TryMe();
    
    /**
     * Constructor for objects of this MainMenuUI
     */
    public MainMenuUI() {
        loanMenu = new LoanMenu();
        borrowerMenu = new BorrowerMenu();
        lpMenu = new LPMenu();
    }
    
    /**
     * This method starts the main menu
     */
    public void start (){
        mainMenu();
    }
    
    /**
     * Method used to display the main menu until theu ser decides to exit
     * Executes the different options based on user input
     */
    public void mainMenu () {
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
                    tryMe.tryMe();
                    break;
                default:
                    System.out.println ("An unexpected error occured with choice: " +choice);
                    break;
            }
        }
    }
    
    /**
     * A method to show the user options and get their input
     */
    private int writeMainMenu () {
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
    
    /**
     * Displays a goodbye message when the user exits
     */
    public void writeEnd () {
        System.out.println ("Thank you for using the program.");
    }
}

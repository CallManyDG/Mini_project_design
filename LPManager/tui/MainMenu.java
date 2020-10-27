package tui;

import java.util.Scanner;

public class MainMenu {
    private LoanUI loanMenu;
    private PersonUI personUI;
    private LPUI lpUI;
    
    public MainMenu() {
        loanMenu = new LoanUI();
        personUI = new PersonUI();
        lpUI = new LPUI();
    }
    
    public void start() {
        mainMenu();
    }
    
    private void mainMenu() {
        boolean running = true;
        while (running) {
            int choice = writeMainMenu();
            switch (choice) {
                case 1:
                  personUI.start();
                  break;
                case 2:
                  lpUI.start();
                  break;
                case 3:
                  loanMenu.start();
                  break;
                case 9:
                  System.out.println("Generating test information");
                  break;
                case 0:
                  System.out.println("Goodbye");
                  running = false;
                  break;
                default:
                  System.out.println("Can't find this option, choice = " + choice);
                  break;
            }
        }
    }

    private int writeMainMenu() {
        System.out.println("-=-=-=-=-=-=-=< Main Menu >=-=-=-=-=-=-=-");
        System.out.println(" (1) Person Menu");
        System.out.println(" (2) LP Menu");
        System.out.println(" (3) Loan Menu");
        System.out.println(" (9) Generate test data");// will generate testdata, delete in final version
        System.out.println(" (0) Exit");
        System.out.print("\n Option >");
        
        int choice = getIntegerByUser();
        return choice;
    }
    
    private int getIntegerByUser() {
        Scanner keyboard = new Scanner(System.in);
        while (!keyboard.hasNextInt()) {
            System.out.println("Invalid input... Try a number!");
            System.out.print(" > ");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
}

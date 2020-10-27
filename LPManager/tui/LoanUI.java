package tui;

import java.util.Scanner;
import control.*;

public class LoanUI {

    LoanController loanCtrl;
    
    public LoanUI() {
        loanCtrl = new LoanController();
    }
    
    //Choose return type
    public void start() {
        boolean running = true;
        while (running) {
            int choice = writeLoanMenu();
            switch (choice) {
                case 1:
                  createLoan();
                  break;
                case 2:

                  break;
                case 3:
                
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
    
    private void createLoan() {
        loanCtrl.createLoan();
    }
    
    private int writeLoanMenu() {
        System.out.println("-=-=-=-=-=-=-=< Main Menu >=-=-=-=-=-=-=-");
        System.out.println(" (1) Create a Loan");
        System.out.println(" (2) Delete a Loan");
        System.out.println(" (1) Update a Loan");
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
package tui;
import java.util.*;

/**
 * Write a description of class LPMenu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LPMenu
{
    public LPMenu ()
    {
    }

    public void start() 
    {
        LPmenu();
    }

    private void LPmenu()
    {
        boolean running = true;
        while (running) {
            int choice = writeLPMenu();
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

    private int writeLPMenu ()
    {
        Scanner keyboard = new Scanner (System.in);
        System.out.println ("*****LP menu*****");
        System.out.println ("(1) ???");
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

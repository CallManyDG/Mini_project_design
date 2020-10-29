package control;

import java.util.*;
import model.*;

/**
 * Controller for the LP. Bridges the gap between UI and Model layers
 * Used to create LP and access information from the model layer
 * 
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 28 October 2020
 */
public class LPController {
    /**
     *  Creates an n LP by given title, author, and pub. date and adds it to the container
     *  Returns true if the action was successful
     */
    public boolean createLP(String title, String author, String publicationDate) {
        boolean result = false;
        LPContainer lpCon = LPContainer.getInstance();
        if(lpCon.getLPByNameAndAuthor(title, author) == null) { //If the LP doesn't exit already
            LP lp = new LP(title, author, publicationDate);
            result = lpCon.addLP(lp);
        }
        return result;
    }

    /**
     *  Adds a copy to an LP specified by title and author. Checks if the copy with that serial number doesn't exist and adds it to the LP copies
     *  Returns true if the action was successful
     */
    public boolean addLPCopy(String title, String author, int serialNumber) {
        boolean result = false;
        LPContainer lpCon = LPContainer.getInstance();
        LP lp = lpCon.getLPByNameAndAuthor(title, author);
        if(lp != null && !copyExists(serialNumber)) { //If the LP exists
            Copy copy = new Copy(serialNumber);
            result = lp.addCopy(copy);
        }
        return result;
    }

    /**
     *  A method used to find the first availabel copy of an LP, specified by title and author
     *  Returns the found copy or null
     */
    public Copy findFirstAvailableCopy(String title, String author) {
        // Find LP by name and author
        Copy copyToReturn = null;
        LPContainer lpCon = LPContainer.getInstance();
        LP lp = lpCon.getLPByNameAndAuthor(title, author);
        // Loop through all the copies
        if(lp != null) {
            Iterator<Copy> it = lp.getAllCopies().iterator();
            boolean searching = true;
            while(it.hasNext() && searching){
                Copy copy = it.next();
                // return the first available copy that has been found
                if(copy.isAvailable()) {
                    copyToReturn = copy;
                    searching = false;
                }
            }
        }
        return copyToReturn;
    }

    /**
     *  Method to check if a Copy with a specific serial number exists
     */
    private boolean copyExists(int serialNumber) {
        Iterator<Copy> it = LPContainer.getInstance().getAllCopies().iterator();
        boolean found = false;
        while(it.hasNext() && !found) {
            Copy currentCopy = it.next();
            if(currentCopy.getSerialNumber() == serialNumber){
                found = true;
            }
        }
        return found;
    }
}

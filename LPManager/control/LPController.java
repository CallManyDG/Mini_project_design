package control;

import java.util.*;
import model.*;

public class LPController {

    public boolean createLP(String title, String author, String publicationDate) {
        boolean result = false;
        LPContainer lpCon = LPContainer.getInstance();
        if(lpCon.getLPByNameAndAuthor(title, author) == null) { //If the LP doesn't exit already
            LP lp = new LP(title, author, publicationDate);
            result = lpCon.addLP(lp);
        }
        return result;
    }

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

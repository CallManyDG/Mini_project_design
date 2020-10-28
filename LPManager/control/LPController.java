package control;

import java.util.*;
import model.*;

public class LPController {
    public Copy findFirstAvailableCopy(String title, String author) {
        // Find LP by name and author
        Copy copyToReturn = null;
        LP lp = getLPByNameAndAuthor(title, author);
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

    private LP getLPByNameAndAuthor(String title, String author) {
        LP lpToReturn = null;
        if(title != null && author != null) {
            Iterator<LP> it = LPContainer.getInstance().getAllLPs().iterator();
            boolean searching = true;
            while(it.hasNext() && searching) {
                LP lp = it.next();
                if(lp.getTitle().equals(title) && lp.getAuthor().equals(author)){
                    lpToReturn = lp;
                    searching = false;
                }
            }
        }
        return lpToReturn;
    }
}

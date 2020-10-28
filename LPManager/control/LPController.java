package control;
import java.util.*;
import model.*;
public class LPController
{
    public Copy findFirstAvailableCopy(String title, String author) {
        // Find LP by name and author
        LP lp = getLPByNameAndAuthor(title, author);
        // Loop through all the copies
        Iterator<Copy> copies = lp.getAllCopies().iterator();
        
        while(copies.hasNext()){
            Copy copy = copies.next();
            // return the first available copy that has been found
            if(copy.isAvailable())
                return copy;
        }
        return null;
            
    }
    
    private LP getLPByNameAndAuthor(String title, String author) {
        Iterator<LP> lps = LPContainer.getInstance().getAllLPs().iterator();
        
        while(lps.hasNext()) {
            LP lp = lps.next();
            
            if(lp.getTitle().equals(title) && lp.getAuthor().equals(author)){
                return lp;
            }
        }
        
        return null;
            
    }
}

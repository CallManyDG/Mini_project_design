package model;

import java.util.ArrayList;
import java.util.Iterator;

public class LPContainer {
    private ArrayList<LP> lps;
    
    private static LPContainer instance = new LPContainer();
    
    private LPContainer() {
        lps = new ArrayList<>();
    }
    
    public static LPContainer getInstance() {
        return instance;
    }

    public boolean addLP(LP lp) {
        boolean result = false;
        if(lp != null) {
            result = lps.add(lp);
        }
        return result;
    }
    
    public boolean removeLP(LP lp) {
        boolean result = false;
        if(lp != null) {
            result = lps.remove(lp);
        }
        return result;
    }
        
    public ArrayList<LP> getAllLPs() {
        return lps;
    }
    
    public ArrayList<Copy> getAllCopies() {
        ArrayList<Copy> copiesToReturn = new ArrayList<>();
        for(LP lp: lps) {
            for(Copy copy: lp.getAllCopies() ) {
                copiesToReturn.add(copy);
            }
        }
        return copiesToReturn;
    }
    
    public LP getLPByNameAndAuthor(String title, String author) {
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

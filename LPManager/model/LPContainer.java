package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is used to represent the container (Singleton) used to store LP information
 * Used to access all LPs
 * 
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 27 October 2020
 */
public class LPContainer {
    //Fields of the class
    private ArrayList<LP> lps;
    
    //A static variable representing the instance of this Singleton class
    private static LPContainer instance = new LPContainer();
    
    /**
     *  Constructor for the instance of the class
     */
    private LPContainer() {
        lps = new ArrayList<>();
    }
    
    /**
     *  A method to access the instance of the class
     */
    public static LPContainer getInstance() {
        return instance;
    }

    /**
     *  A method to add a LP to the container
     *  returns true if the operation was successful
     */
    public boolean addLP(LP lp) {
        boolean result = false;
        if(lp != null) {
            result = lps.add(lp);
        }
        return result;
    }
    
    /**
     *  A method to remove a LP the container
     *  returns true if the operation was successful
     */
    public boolean removeLP(LP lp) {
        boolean result = false;
        if(lp != null) {
            result = lps.remove(lp);
        }
        return result;
    }
     
    /**
     *  Accessor method used to get all LPs in the container
     */
    public ArrayList<LP> getAllLPs() {
        return lps;
    }
    
    /**
     *  Accessor method used to get all copies from all LPs
     */
    public ArrayList<Copy> getAllCopies() {
        ArrayList<Copy> copiesToReturn = new ArrayList<>();
        for(LP lp: lps) {
            for(Copy copy: lp.getAllCopies() ) {
                copiesToReturn.add(copy);
            }
        }
        return copiesToReturn;
    }
    
    /**
     *  A method to get a specific LP by title and author
     *  returns the found LP or a null
     */
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

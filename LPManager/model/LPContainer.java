package model;

import java.util.ArrayList;

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
        if(!lps.isEmpty()) {
            return lps;
        }
        return null;
    }
}

package model;

/**
 * This class is used to represent a physical copy of the LP. Each copy has a serial number and
 * availability which shows if it is loaned or not
 * 
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 27 October 2020
 */
public class Copy {
    //Fields of the class
    private int serialNumber;
    private boolean available;
    
    /**
     * Constructor for objects of class Copy
     */
    public Copy(int serialNumber) {
        this.serialNumber = serialNumber;
        available = true;
    }
    
    /**
     *  Accessors for the serialNumber and availability
     */
    public int getSerialNumber() {
        return serialNumber;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    /**
     *  Mutators for the serialNumber and availability
     */
    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
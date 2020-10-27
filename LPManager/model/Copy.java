package model;

public class Copy {
    private int serialNumber;
    private boolean available;
    
    public Copy(int serialNumber) {
        this.serialNumber = serialNumber;
        available = true;
    }
    
    /**
     * Set the serial number of the copy
     */
    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
    
    /**
     * Set the availability of the copy
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    /**
     * Get the serial number of the copy
     */
    public int getSerialNumber() {
        return serialNumber;
    }
    
    /**
     *  Check the availability of the copy
     */
    public boolean isAvailable() {
        return available;
    }
}
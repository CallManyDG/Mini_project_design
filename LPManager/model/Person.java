package model;

import java.util.ArrayList;

/**
 * This class is used to represent a person and his loans. Includes all needed accessors and mutators
 * 
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 27 October 2020
 */
public class Person {
    //Fields of the class
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String phone;
    private ArrayList<Loan> loans;

    /**
     *  Constructor for objects of class Person
     */
    public Person(String name, String address, String postalCode, String city, String phone) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
        this.loans = new ArrayList<>();
    }

    /**
     *  Accessors for the name, address, postalCode, city, phone and loans fields
     */
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public ArrayList<Loan> getLoans() {
        return loans;
    }

    /**
     *  Mutators for the name, address, postalCode, city, phone and loans fields
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     *   Adds a loan to the list of loans of the person
     */
    public boolean addLoan(Loan loan) {
        boolean result = false;
        if (loan != null) {
            result = loans.add(loan);
        }
        return result;
    }
    
    /**
     *  Removes a set loan from the list of loans of the person
     */
    public boolean removeLoan(Loan loan) {
        boolean result = false;
        if (loan != null) {
            result = loans.remove(loan);
        }
        return result;
    }
}
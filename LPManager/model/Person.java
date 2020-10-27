package model;

import java.util.ArrayList;

public class Person {
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String phone;
    private ArrayList<Loan> loans;

    public Person(String name, String address, String postalCode, String city, String phone) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
        this.loans = new ArrayList<>();
    }

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
    
    public boolean addLoan(Loan loan) {
        boolean result = false;
        if (loan != null) {
            result = loans.add(loan);
        }
        return result;
    }
    
    public boolean removeLoan(Loan loan) {
        boolean result = false;
        if (loan != null) {
            result = loans.remove(loan);
        }
        return result;
    }
}
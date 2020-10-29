package model;

import java.util.ArrayList;

/**
 * This class is used to represent an LP. It has an author, title, publication date
 * and a list of copies
 * 
 * @author Group1 for MiniProject-Design DMAI0920
 * @version 27 October 2020
 */
public class LP {
    //Fields of the class
    private String title;
    private String author;
    private String publicationDate;
    private ArrayList<Copy> copies;

    /**
     * Constructor for objects of class LP
     */
    public LP(String title, String author, String publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        copies = new ArrayList<>();
    }

    /**
     *  Accessors for the title, author, publicationDate, copies
     */
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public ArrayList<Copy> getAllCopies() {
        return copies;
    }
    
    /**
     *  Mutators for the title, author, publicationDate, copies
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     *  Add a copy to the copy list
     */
    public boolean addCopy(Copy copy) {
        boolean result = false;
        if(copy != null) { //Only if the copy is set
            result = copies.add(copy);
        }
        return result;
    }

    /**
     *  Remove a copy from the copy list
     */
    public boolean removeCopy(Copy copy) {
        boolean result = false;
        if(copy != null) {
            result = copies.remove(copy);
        }
        return result;
    }
}
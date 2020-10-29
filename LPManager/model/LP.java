package model;

import java.util.ArrayList;

public class LP {
    // initialize the class fileds
    private String title;
    private String author;
    private String publicationDate;
    private ArrayList<Copy> copies;

    public LP(String title, String author, String publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        copies = new ArrayList<>();
    }

    /**
     *  Set the title of the LP
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *  Set the author of the LP
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *  Set the publication date of the LP
     */
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     *  Get the title
     */
    public String getTitle() {
        return title;
    }

    /**
     *  Get the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *  Get the publication date
     */
    public String getPublicationDate() {
        return publicationDate;
    }

    /**
     *  Get all copies
     */
    public ArrayList<Copy> getAllCopies() {
        return copies;
    }

    /**
     *  Add a copy
     */
    public boolean addCopy(Copy copy) {
        boolean result = false;
        if(copy != null) { //Only if the copy is set
            result = copies.add(copy);
        }
        return result;
    }

    /**
     *  Remove a copy
     */
    public boolean removeCopy(Copy copy) {
        boolean result = false;
        if(copy != null) {
            result = copies.remove(copy);
        }
        return result;
    }
}
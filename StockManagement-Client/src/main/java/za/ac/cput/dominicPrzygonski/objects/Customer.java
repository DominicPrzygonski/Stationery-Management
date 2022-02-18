package za.ac.cput.dominicPrzygonski.objects;

import java.io.Serializable;

/**
 *
 * @author Dominic Przygonski
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    
    String id, fname, lname;
    
    public Customer(String id, String fname, String lname){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    
    
}
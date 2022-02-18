package za.ac.cput.dominicPrzygonski.objects;

import java.io.Serializable;

/**
 *
 * @author Dominic Przygonski
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    String id, fName, lName, password;
    boolean active;
    
    public User(String id, String fName, String lName, String password, boolean active){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
    
}

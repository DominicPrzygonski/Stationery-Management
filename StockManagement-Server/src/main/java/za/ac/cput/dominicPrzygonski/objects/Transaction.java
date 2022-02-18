package za.ac.cput.dominicPrzygonski.objects;

import java.io.Serializable;

/**
 *
 * @author Dominic Przygonski
 */
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    
    String id, customerID, productID;
    int amount;
    
    public Transaction(String id, String customerID, String productID, int amount){
        this.id = id;
        this.customerID = customerID;
        this.productID = productID;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    
}

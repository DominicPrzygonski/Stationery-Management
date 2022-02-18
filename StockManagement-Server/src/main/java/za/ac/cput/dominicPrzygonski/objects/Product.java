package za.ac.cput.dominicPrzygonski.objects;

import java.io.Serializable;

/**
 *
 * @author Dominic Przygonski
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    String id, name, description, category;
    int quantity;
    double price;
    
    public Product(String id, String name, String description, String category, double price, int quantity){
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}

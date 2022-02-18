package za.ac.cput.dominicPrzygonski.objects;

/**
 *
 * @author Dominic Przygonski
 */
public class SalesReport {
    
    String product, id;
    int amount, total;
    double productPrice;
    
    public SalesReport(String id, String product, double productPrice){
        this.id = id;
        this.product = product;
        this.productPrice = productPrice;
        this.amount = 0;
        this.total = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
}

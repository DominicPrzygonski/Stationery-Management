package za.ac.cput.dominicPrzygonski.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import za.ac.cput.dominicPrzygonski.connection.DBConnection;
import za.ac.cput.dominicPrzygonski.objects.Customer;
import za.ac.cput.dominicPrzygonski.objects.Product;
import za.ac.cput.dominicPrzygonski.objects.Transaction;
import za.ac.cput.dominicPrzygonski.objects.User;

/**
 *
 * @author Dominic Przygonski
 */
public class DAO {
    
     private final Connection con;
    
    public DAO() throws SQLException{
        this.con = DBConnection.derbyConnection();
    }
    
    public boolean findAdmin(String id, String password) throws SQLException{
        String find_admin = "SELECT * FROM admin_table WHERE admin_id = ? AND admin_password = ?";
        
        System.out.println(id + password);
        
        PreparedStatement ps = this.con.prepareStatement(find_admin);
        ps.setString(1, id);
        ps.setString(2, password);
        
        ResultSet rs = ps.executeQuery();
        
        
        if(rs.next()){
            ps.close();
            rs.close();
            return true;
        } else {
            ps.close();
            rs.close();
            return false;
        }

    }
    
    public boolean findUser(String id, String password) throws SQLException{
        String find_admin = "SELECT * FROM user_table WHERE user_id = ? AND user_password = ?";
        
        System.out.println(id + password);
        
        PreparedStatement ps = this.con.prepareStatement(find_admin);
        ps.setString(1, id);
        ps.setString(2, password);
        
        ResultSet rs = ps.executeQuery();
        
        
        if(rs.next()){
            ps.close();
            rs.close();
            return true;
        } else {
            ps.close();
            rs.close();
            return false;
        }

    }
    
    public Boolean addProduct(String id, String name, String des, String cat, double price, int quan) throws SQLException{
        String insertSQL = "INSERT INTO products(id, name, description, category, price, quantity) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = this.con.prepareStatement(insertSQL);
        ps.setString(1, id);
        ps.setString(2, name);
        ps.setString(3, des);
        ps.setString(4, cat);
        ps.setDouble(5, price);
        ps.setInt(6, quan);
        ps.executeUpdate();
        ps.close();
        
        return true;
    }
    
    public Boolean addUser(String id, String fname, String lname, String password) throws SQLException{
        String insertSQL = "INSERT INTO user_table(user_id, user_fname, user_lname, user_password, active) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = this.con.prepareStatement(insertSQL);
        ps.setString(1, id);
        ps.setString(2, fname);
        ps.setString(3, lname);
        ps.setString(4, password);
        ps.setBoolean(5, true);
        ps.executeUpdate();
        ps.close();
        
        return true;
    }
    
    public ArrayList<Product> getAllProducts() throws SQLException{
        String get_all_SQL = "SELECT * FROM products";
        ArrayList<Product> products = new ArrayList<>();
        PreparedStatement ps = this.con.prepareStatement(get_all_SQL);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            
            String id = rs.getString("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            String category = rs.getString("category");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
             
            Product product = new Product(id, name, description, category, price, quantity);
            products.add(product);  
            
        }
        rs.close();
        ps.close();
        return products;
    }
    
     public ArrayList<User> getAllUsers() throws SQLException{
        String get_all_SQL = "SELECT * FROM user_table";
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement ps = this.con.prepareStatement(get_all_SQL);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            
            String id = rs.getString("user_id");
            String fname = rs.getString("user_fname");
            String lname = rs.getString("user_lname");
            String password = rs.getString("user_password");
            boolean active = rs.getBoolean("active");
            
            
             
            User user = new User(id, fname, lname, password, active);
            
            users.add(user);  
            
        }
        rs.close();
        ps.close();
        return users;
    }
     
     public boolean editProduct(String id, String name, String description, String category, double price, int quantity) throws SQLException{
         String updateSQL = "UPDATE products SET name = ?, description = ?, category = ?, price = ?, quantity = ?  WHERE id = ? ";
         
         PreparedStatement ps = this.con.prepareStatement(updateSQL);
         ps.setString(1, name);
         ps.setString(2, description);
         ps.setString(3, category);
         ps.setDouble(4, price);
         ps.setInt(5, quantity);
         ps.setString(6, id);
         int value = ps.executeUpdate();
         ps.close();
         
         
         
         if(value > 0){
             return true;
         }else{
             return false;
         }
    }
     
    public boolean deleteProduct(String id) throws SQLException{
         String deleteSQL = "DELETE FROM products WHERE id = ?";
         PreparedStatement ps = this.con.prepareStatement(deleteSQL);
         ps.setString(1, id);
         int value = ps.executeUpdate();
         ps.close();

         if(value > 0){
             return true;
         }else{
             return false;
         }
    }
    
    public boolean editUser(String id, String fname, String lname, String password) throws SQLException{
         String updateSQL = "UPDATE user_table SET user_fname = ?, user_lname = ?, user_password = ? WHERE user_id = ? ";
         
         PreparedStatement ps = this.con.prepareStatement(updateSQL);
         ps.setString(1, fname);
         ps.setString(2, lname);
         ps.setString(3, password);
         ps.setString(4, id);
         int value = ps.executeUpdate();
         ps.close();

         if(value > 0){
             return true;
         }else{
             return false;
         }
    }
    
    public boolean deleteUser(String id) throws SQLException{
         String deleteSQL = "UPDATE user_table SET active = ? WHERE user_id = ? ";
         PreparedStatement ps = this.con.prepareStatement(deleteSQL);
         ps.setBoolean(1, false);
         ps.setString(2, id);
         int value = ps.executeUpdate();
         ps.close();

         if(value > 0){
             return true;
         }else{
             return false;
         }
    }
    
    public ArrayList<Customer> getAllCustomers() throws SQLException{
        String get_all_SQL = "SELECT * FROM customer";
        ArrayList<Customer> customers = new ArrayList<>();
        PreparedStatement ps = this.con.prepareStatement(get_all_SQL);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            
            String id = rs.getString("id");
            String fname = rs.getString("fname");
            String lname = rs.getString("lname");
            
            
             
            Customer customer = new Customer(id, fname, lname);
            
            customers.add(customer);  
            
        }
        rs.close();
        ps.close();
        return customers;
    }
    
     public Boolean addCustomer(String id, String fname, String lname) throws SQLException{
        String insertSQL = "INSERT INTO customer(id, fname, lname) "
                + "VALUES (?, ?, ? )";
        PreparedStatement ps = this.con.prepareStatement(insertSQL);
        ps.setString(1, id);
        ps.setString(2, fname);
        ps.setString(3, lname);
        ps.executeUpdate();
        ps.close();
        
        return true;
    }
     
     
    public ArrayList<Transaction> getAllTransaction() throws SQLException{
        String get_all_SQL = "SELECT * FROM transactions";
        ArrayList<Transaction> transactions = new ArrayList<>();
        PreparedStatement ps = this.con.prepareStatement(get_all_SQL);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            
            String id = rs.getString("id");
            String customerID = rs.getString("customerID");
            String productID = rs.getString("productID");
            int amount = rs.getInt("amount");
            
            
             
            Transaction transaction = new Transaction(id, customerID, productID, amount);
            
            transactions.add(transaction);  
            
        }
        rs.close();
        ps.close();
        return transactions;
    }    
    
    public Boolean addTransaction(String customerID, String productID, int amount) throws SQLException {
        String insertSQL = "INSERT INTO transactions(customerID, productID, amount) "
                + "VALUES (?, ?, ?)";
        PreparedStatement ps = this.con.prepareStatement(insertSQL);
        ps.setString(1, customerID);
        ps.setString(2, productID);
        ps.setInt(3, amount);
        ps.executeUpdate();
        ps.close();

        String updateSQL = "UPDATE products SET quantity = quantity - ? WHERE id = ? ";

        PreparedStatement ps1 = this.con.prepareStatement(updateSQL);
        ps1.setInt(1, amount);
        ps1.setString(2, productID);

        ps1.executeUpdate();
        ps1.close();

        return true;
    }
    
}

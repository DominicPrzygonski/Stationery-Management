package za.ac.cput.dominicPrzygonski.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import za.ac.cput.dominicPrzygonski.objects.Customer;
import za.ac.cput.dominicPrzygonski.objects.Product;
import za.ac.cput.dominicPrzygonski.objects.Transaction;
import za.ac.cput.dominicPrzygonski.objects.User;

/**
 *
 * @author Dominic Przygonski
 */
public class Client {

    private Socket server;

    public boolean login(String msg, String id, String password) {

        try {
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            switch (msg) {
                case "adminLogin":
                    out.writeObject(msg);
                    out.flush();

                    out.writeObject(id);
                    out.flush();

                    out.writeObject(password);
                    out.flush();

                    Boolean responseAdmin = (Boolean) in.readObject();

                    if (responseAdmin) {
                        out.close();
                        in.close();
                        server.close();
                        return true;
                    } else {
                        out.close();
                        in.close();
                        server.close();
                        return false;
                    }

                case "userLogin":
                    out.writeObject(msg);
                    out.flush();

                    out.writeObject(id);
                    out.flush();

                    out.writeObject(password);
                    out.flush();

                    Boolean responseUser = (Boolean) in.readObject();

                    if (responseUser) {
                        out.close();
                        in.close();
                        server.close();
                        return true;
                    } else {
                        out.close();
                        in.close();
                        server.close();
                        return false;
                    }

                default:
                    out.writeObject("Invalid Option");
            }

        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        return false;
    }
    
    public boolean addProduct(String id, String name, String description, String category, double price, int quantity) {

         try {
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject("addProduct");
            out.flush();

            out.writeObject(id);
            out.flush();

            out.writeObject(name);
            out.flush();
            
            out.writeObject(description);
            out.flush();
     
            out.writeObject(category);
            out.flush();

            out.writeObject(price);
            out.flush();

            out.writeObject(quantity);
            out.flush();

            Boolean responseUser = (Boolean) in.readObject();
            if (responseUser) {
                out.close();
                in.close();
                server.close();
                return true;
            } else {
                out.close();
                in.close();
                server.close();
                return false;
            }

        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        return false;
    }
    
    public boolean addUser(String id, String fname, String lname, String password) {

         try {
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject("addUser");
            out.flush();

            out.writeObject(id);
            out.flush();

            out.writeObject(fname);
            out.flush();
            
            out.writeObject(lname);
            out.flush();
     
            out.writeObject(password);
            out.flush();

            Boolean responseUser = (Boolean) in.readObject();
            if (responseUser) {
                out.close();
                in.close();
                server.close();
                return true;
            } else {
                out.close();
                in.close();
                server.close();
                return false;
            }

        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        return false;
    }
    
    public ArrayList<Product> getAllProducts() {
        
        ArrayList<Product> products = new ArrayList();
        
         try {
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject("getAllProducts");
            out.flush();
 
            
            products = (ArrayList) in.readObject();
            return products;
            
        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        return products;
    }
    
    public ArrayList<User> getAllUsers() {
        
        ArrayList<User> users = new ArrayList();
        
         try {
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject("getAllUsers");
            out.flush();
 
            
            users = (ArrayList) in.readObject();
            return users;
            
        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        return users;
    }
    
     public boolean editProduct(String id, String name, String description, String category, double price, int quantity) {

         try {
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject("editProduct");
            out.flush();

            out.writeObject(id);
            out.flush();

            out.writeObject(name);
            out.flush();
            
            out.writeObject(description);
            out.flush();
     
            out.writeObject(category);
            out.flush();

            out.writeObject(price);
            out.flush();

            out.writeObject(quantity);
            out.flush();

            Boolean responseUser = (Boolean) in.readObject();
            if (responseUser) {
                out.close();
                in.close();
                server.close();
                return true;
            } else {
                out.close();
                in.close();
                server.close();
                return false;
            }

        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        return false;
    }
     
     public boolean deleteProduct(String id) {

        try {
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject("deleteProduct");
            out.flush();

            out.writeObject(id);
            out.flush();

            Boolean responseUser = (Boolean) in.readObject();
            if (responseUser) {
                out.close();
                in.close();
                server.close();
                return true;
            } else {
                out.close();
                in.close();
                server.close();
                return false;
            }

        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        return false;
    }
     
     public boolean editUser(String id, String fname, String lname, String password) {

         try {
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject("editUser");
            out.flush();

            out.writeObject(id);
            out.flush();

            out.writeObject(fname);
            out.flush();
            
            out.writeObject(lname);
            out.flush();
     
            out.writeObject(password);
            out.flush();

            Boolean responseUser = (Boolean) in.readObject();
            if (responseUser) {
                out.close();
                in.close();
                server.close();
                return true;
            } else {
                out.close();
                in.close();
                server.close();
                return false;
            }

        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        return false;
    }
     
     
     public boolean deleteUser(String id) {

        try {
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject("deleteUser");
            out.flush();

            out.writeObject(id);
            out.flush();

            Boolean responseUser = (Boolean) in.readObject();
            if (responseUser) {
                out.close();
                in.close();
                server.close();
                return true;
            } else {
                out.close();
                in.close();
                server.close();
                return false;
            }

        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        return false;
    }
     
    public ArrayList<Customer> getAllCustomers() {
        
        ArrayList<Customer> customers = new ArrayList();
        
         try {
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject("getAllCustomers");
            out.flush();
 
            
            customers = (ArrayList) in.readObject();
            return customers;
            
        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        return customers;
    }
    
    public boolean addCustomer(String id, String fname, String lname) {

         try {
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject("addCustomer");
            out.flush();

            out.writeObject(id);
            out.flush();

            out.writeObject(fname);
            out.flush();
            
            out.writeObject(lname);
            out.flush();
     

            Boolean responseUser = (Boolean) in.readObject();
            if (responseUser) {
                out.close();
                in.close();
                server.close();
                return true;
            } else {
                out.close();
                in.close();
                server.close();
                return false;
            }

        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        return false;
    }
    
    public ArrayList<Transaction> getAllTransactions() {
        
        ArrayList<Transaction> transaction = new ArrayList();
        
         try {
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject("getAllTransactions");
            out.flush();
 
            
            transaction = (ArrayList) in.readObject();
            return transaction;
            
        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        return transaction;
    }
    
    public boolean addTransaction(String customerID, String productID, int amount) {

         try {
            server = new Socket("127.0.0.1", 12345);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        try {

            ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(server.getInputStream());

            out.writeObject("addTransaction");
            out.flush();

            out.writeObject(customerID);
            out.flush();
            
            out.writeObject(productID);
            out.flush();
     
            out.writeObject(amount);
            out.flush();
     

            Boolean responseUser = (Boolean) in.readObject();
            if (responseUser) {
                out.close();
                in.close();
                server.close();
                return true;
            } else {
                out.close();
                in.close();
                server.close();
                return false;
            }

        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found: " + cnfe.getMessage());
        }
        return false;
    }
}

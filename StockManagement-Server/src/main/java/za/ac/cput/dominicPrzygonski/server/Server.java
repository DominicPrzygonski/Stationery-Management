package za.ac.cput.dominicPrzygonski.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.cput.dominicPrzygonski.dao.DAO;
import za.ac.cput.dominicPrzygonski.objects.Customer;
import za.ac.cput.dominicPrzygonski.objects.Product;
import za.ac.cput.dominicPrzygonski.objects.Transaction;
import za.ac.cput.dominicPrzygonski.objects.User;

/**
 *
 * @author Dominic Przygonski
 */
public class Server {

    private ServerSocket listener;
    private Socket client;
    private DAO dao;
    private Boolean value = true;

    public Server() {
        
        try {
            listener = new ServerSocket(12345, 10);
        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
        }
        
        try {
            dao = new DAO();
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void listen() {       
        while (value) {
            try {

                try {
                    client = listener.accept();
                } catch (IOException ioe) {
                    System.out.println("IO Exception: " + ioe.getMessage());
                }

                ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                out.flush();
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());

                String msg = (String) in.readObject();

                switch (msg) {
                    case "adminLogin":
                        String adminID = (String) in.readObject();
                        String adminPassword = (String) in.readObject();

                        try {
                            boolean adminVerification = dao.findAdmin(adminID, adminPassword);
                            System.out.println(adminVerification);
                            
                            out.writeObject(adminVerification);
                            out.flush();
                        } catch (SQLException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;

                    case "userLogin":
                        String userID = (String) in.readObject();
                        String userPassword = (String) in.readObject();

                        try {
                            boolean userVerification = dao.findUser(userID, userPassword);
                            System.out.println(userVerification);

                            out.writeObject(userVerification);
                            out.flush();
                        } catch (SQLException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;

                    case "addProduct":
                        String productID = (String) in.readObject();
                        String productName = (String) in.readObject();
                        String productDes = (String) in.readObject();
                        String productCat = (String) in.readObject();
                        double productPrice = (double) in.readObject();
                        int productQuan = (int) in.readObject();

                        try {
                            boolean productVerification = dao.addProduct(productID, productName, productDes, productCat, productPrice, productQuan);
                            System.out.println(productVerification);

                            out.writeObject(productVerification);
                            out.flush();
                        } catch (SQLException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                        
                    case "addUser":
                        String userIDValue = (String) in.readObject();
                        String firstName = (String) in.readObject();
                        String lastName = (String) in.readObject();
                        String password = (String) in.readObject();

                        try {
                            boolean productVerification = dao.addUser(userIDValue, firstName, lastName, password);
                            System.out.println(productVerification);

                            out.writeObject(productVerification);
                            out.flush();
                        } catch (SQLException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;

                    case "getAllProducts":

                        try {
                        ArrayList<Product> products = new ArrayList();
                        products = dao.getAllProducts();

                        out.writeObject(products);
                        out.flush();
                    } catch (SQLException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                    
                    case "getAllUsers":

                        try {
                        ArrayList<User> users = new ArrayList();
                        users = dao.getAllUsers();

                        out.writeObject(users);
                        out.flush();
                    } catch (SQLException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                    
                    case "editProduct":
                        String updateProductID = (String) in.readObject();
                        String updateProductName = (String) in.readObject();
                        String updateProductDes = (String) in.readObject();
                        String updateProductCat = (String) in.readObject();
                        double updateProductPrice = (double) in.readObject();
                        int updateProductQuan = (int) in.readObject();

                        try {
                            boolean productVerification = dao.editProduct(updateProductID, updateProductName, updateProductDes, updateProductCat, updateProductPrice, 
                                    updateProductQuan);
                            System.out.println(productVerification);

                            out.writeObject(productVerification);
                            out.flush();
                        } catch (SQLException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                        
                        
                     case "deleteProduct":
                        String deleteID = (String) in.readObject();
                        

                        try {
                            boolean productVerification = dao.deleteProduct(deleteID);
                            System.out.println(productVerification);

                            out.writeObject(productVerification);
                            out.flush();
                        } catch (SQLException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                        
                        
                    case "editUser":
                        String updateUserID = (String) in.readObject();
                        String updateUserFName = (String) in.readObject();
                        String updateUserLName = (String) in.readObject();
                        String updateUserPassword = (String) in.readObject();

                        try {
                            boolean productVerification = dao.editUser(updateUserID, updateUserFName, updateUserLName, updateUserPassword);
                            System.out.println(productVerification);

                            out.writeObject(productVerification);
                            out.flush();
                        } catch (SQLException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;

                    case "deleteUser":
                        String deleteUserID = (String) in.readObject();

                        try {
                            boolean productVerification = dao.deleteUser(deleteUserID);
                            System.out.println(productVerification);

                            out.writeObject(productVerification);
                            out.flush();
                        } catch (SQLException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                        
                    case "getAllCustomers":

                        try {
                        ArrayList<Customer> customer = new ArrayList();
                        customer = dao.getAllCustomers();

                        out.writeObject(customer);
                        out.flush();
                    } catch (SQLException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                    
                    
                    case "addCustomer":
                        String customerID = (String) in.readObject();
                        String customerFName = (String) in.readObject();
                        String customerLName = (String) in.readObject();


                        try {
                            boolean productVerification = dao.addCustomer(customerID, customerFName, customerLName);
                            System.out.println(productVerification);

                            out.writeObject(productVerification);
                            out.flush();
                        } catch (SQLException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                        
                    case "getAllTransactions":

                        try {
                        ArrayList<Transaction> transaction = new ArrayList();
                        transaction = dao.getAllTransaction();

                        out.writeObject(transaction);
                        out.flush();
                    } catch (SQLException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                    
                    case "addTransaction":
                        String customerIDTransaction = (String) in.readObject();
                        String productIDTranaction = (String) in.readObject();
                        int amountTransaction = (int) in.readObject();


                        try {
                            boolean productVerification = dao.addTransaction(customerIDTransaction, productIDTranaction, amountTransaction);
                            System.out.println(productVerification);

                            out.writeObject(productVerification);
                            out.flush();
                        } catch (SQLException ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;

                    case "Stop":
                        value = false;
                        break;

                    default:
                        out.writeObject("Invalid Option");
                }
                
                out.close();
                in.close();
                client.close();

            } catch (IOException ioe) {
                System.out.println("IO Exception: " + ioe.getMessage());
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class not found: " + cnfe.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        Server server = new Server();
        server.listen();
    }

}

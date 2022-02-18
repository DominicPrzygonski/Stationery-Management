package za.ac.cput.dominicPrzygonski.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import za.ac.cput.dominicPrzygonski.client.Client;
import za.ac.cput.dominicPrzygonski.objects.Customer;
import za.ac.cput.dominicPrzygonski.objects.Product;
import za.ac.cput.dominicPrzygonski.objects.SalesReport;
import za.ac.cput.dominicPrzygonski.objects.Transaction;
import za.ac.cput.dominicPrzygonski.objects.User;

/**
 *
 * @author Dominic Przygonski
 */
public class GUI implements ActionListener, ItemListener{
    
    private Client client;
    private JFrame loginFrame, adminFrame, userFrame;
    private JPanel loginTitlePanel, loginBodyPanel, loginButtonPanel, adminTitlePanel, userTitlePanel, adminBodyPanel, adminProductPanel, adminUserPanel, adminProductUpdatePanel,
            adminUserUpdatePanel, displayPanelProduct, displayPanelUser, logoutPanel, userBodyPanel, userCustomerPanel, displayPanelCustomer, userTransactionPanel
            ,displayPanelTransaction, customerTransaction, customerTransactionDisplayPanel, userSouthPanel, logoutPanelUser, salesReportPane;
    
    private JLabel loginTitle, employeeID, employeePassword, adminTitle, userTitle, productID, productName, productDes, productCat, productPrice, productQuan
            , userID, userFName, userLName, userPassword, setProduct, updateProductID, updateProductName, updateProductDes, updateProductCat, updateProductPrice, updateProductQuan,
            setUser, updateUserID, updateUserFName, updateUserLName, updateUserPassword, productHeader, userHeader, updateProductHeader, updateUserHeader, customerHeader,
            customerID, customerFName, customerLName, transactionHeader, setUserCustomer, setUserProduct, productAmount, customerTransactionHeader, setCustomerTransactions
             , salesReportHeader, salesReportTotal;
    
    private JTextField employeeIDTXT, employeePasswordTXT, productIDTXT, productNameTXT, productDesTXT, productPriceTXT, productQuanTXT, userIDTXT, userFNameTXT,
            userLNameTXT, userPasswordTXT, updateProductIDTXT, updateProductNameTXT, updateProductDesTXT, updateProductPriceTXT, updateProductQuanTXT, updateUserIDTXT
            , updateUserFNameTXT, updateUserLNameTXT, updateUserPasswordTXT, customerIDTXT, customerFNameTXT, customerLNameTXT, productAmountTXT, salesReportTotal2;
    
    private JButton adminLogin, userLogin, addingProduct, addingUser, updatingProduct, updateUser, deleteUser, deletingProduct, logoutAdmin, addingCustomer, addingTransaction
            , logoutUser;
    private Font font1, font2, font3;
    private JComboBox productCatcomboBox, setProductComboBox, updateProductCatcomboBox, setUserComboBox, setCustomerComboBox, setUserProductComboBox, setCustomerTransactionComboBox
            ;
    private JTable TableProduct, TableUser, TableCustomer, TableTransaction1, TableTransactionProducts, TableTransactionCustomer, TableTransactionSales;
    private JScrollPane productScroll, userScroll, customerScroll, transactionScroll, userProductsScroll, userTransactionCusScroll, userTransactionSalesScroll;
    private DefaultTableModel modelTransactionCustomer;
    
    public GUI(){
        
        client = new Client();
        
        //---------------------------------------------------------------------------------------
        
        //Login

        //Setting login frame
        loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        
        //Login title panel
        loginTitlePanel = new JPanel();
        loginTitlePanel.setBorder(new EmptyBorder(0,0,0,0));
        loginTitle = new JLabel("LOGIN", SwingConstants.CENTER);
        loginTitle.setForeground(Color.WHITE);
        font1 = new Font("Copperplate Gothic Bold", Font.BOLD, 60);
        loginTitle.setFont(font1);
        loginTitle.setBorder(new EmptyBorder(10,0,10,0));
        
        //Login body panel
        loginBodyPanel = new JPanel();
        font2 = new Font("Dialog", Font.BOLD, 16);
        
        //Login section
        employeeID = new JLabel("Employee ID:", SwingConstants.CENTER);
        employeeID.setFont(font2);
        employeeID.setForeground(Color.WHITE);
        employeeIDTXT = new JTextField(20);
        employeeIDTXT.setFont(font2);
        
        
        
        employeePassword = new JLabel("Employee Password:", SwingConstants.CENTER);
        employeePassword.setFont(font2);
        employeePassword.setForeground(Color.WHITE);
        employeePasswordTXT = new JTextField(20);
        employeePasswordTXT.setFont(font2);
        
        
        //Button section
        loginButtonPanel = new JPanel();
        
        adminLogin = new JButton("Admin Login");
        adminLogin.setFont(font2);
        adminLogin.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 4));
        
        userLogin = new JButton("User Login");
        userLogin.setFont(font2);
        userLogin.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 4));
        
        //Adding background color
        loginTitlePanel.setBackground(new Color(0, 153, 237));
        loginBodyPanel.setBackground(new Color(0, 153, 237));
        loginButtonPanel.setBackground(new Color(0, 153, 237));
        
        //---------------------------------------------------------------------------------------

        //Admin
        
        //Setting admin frame
        adminFrame = new JFrame("Admin");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

        
        //Admin title panel
        adminTitlePanel = new JPanel();
        adminTitlePanel.setBorder(new EmptyBorder(0,0,0,0));
        adminTitle = new JLabel("Admin Account", SwingConstants.CENTER);
        adminTitle.setForeground(Color.WHITE);
        font3 = new Font("Copperplate Gothic Bold", Font.BOLD, 50);
        adminTitle.setFont(font3);
        adminTitle.setBorder(new EmptyBorder(10,0,10,0));

        //Admin body panel
        adminBodyPanel = new JPanel();
        font2 = new Font("Dialog", Font.BOLD, 16);
        
        //Adding Product
        adminProductPanel = new JPanel();
        
        productHeader = new JLabel("ADD PRODUCT", SwingConstants.CENTER);
        productHeader.setFont(font2);
        productHeader.setForeground(Color.BLACK);
        
        productID = new JLabel("Product ID:", SwingConstants.CENTER);
        productID.setFont(font2);
        productID.setForeground(Color.WHITE);
        productIDTXT = new JTextField(20);
        productIDTXT.setFont(font2);
        productIDTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (productIDTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        productName = new JLabel("Product Name:", SwingConstants.CENTER);
        productName.setFont(font2);
        productName.setForeground(Color.WHITE);
        productNameTXT = new JTextField(20);
        productNameTXT.setFont(font2);
        productNameTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (productNameTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        productDes = new JLabel("Product Description:", SwingConstants.CENTER);
        productDes.setFont(font2);
        productDes.setForeground(Color.WHITE);
        productDesTXT = new JTextField(20);
        productDesTXT.setFont(font2);
        productDesTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (productDesTXT.getText().length() >= 50)
                {
                    e.consume();
                }
            }
        });
        
        productCat = new JLabel("Product Category:", SwingConstants.CENTER);
        productCat.setFont(font2);
        productCat.setForeground(Color.WHITE);
        productCatcomboBox = new JComboBox();
        productCatcomboBox.setFont(font2);
        productCatcomboBox.addItem("Other");
        productCatcomboBox.addItem("Writing");
        productCatcomboBox.addItem("Filing");
        productCatcomboBox.addItem("Business");
        productCatcomboBox.addItem("Drawing");
        productCatcomboBox.addItem("Mailing");
        productCatcomboBox.addItem("School");

        
        productPrice = new JLabel("Product Price:", SwingConstants.CENTER);
        productPrice.setFont(font2);
        productPrice.setForeground(Color.WHITE);
        productPriceTXT = new JTextField(20);
        productPriceTXT.setFont(font2);
        
        
        productQuan = new JLabel("Product Quantity:", SwingConstants.CENTER);
        productQuan.setFont(font2);
        productQuan.setForeground(Color.WHITE);
        productQuanTXT = new JTextField(20);
        productQuanTXT.setFont(font2);
        
        addingProduct = new JButton("Add");
        addingProduct.setFont(font2);
        addingProduct.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 4));
        
        
        
        //Adding User
        adminUserPanel = new JPanel();
        
        userHeader = new JLabel("ADD USER", SwingConstants.CENTER);
        userHeader.setFont(font2);
        userHeader.setForeground(Color.BLACK);
        
        userID = new JLabel("User ID:", SwingConstants.CENTER);
        userID.setFont(font2);
        userID.setForeground(Color.WHITE);
        userIDTXT = new JTextField(20);
        userIDTXT.setFont(font2);
        userIDTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (userIDTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        userFName = new JLabel("User First Name:", SwingConstants.CENTER);
        userFName.setFont(font2);
        userFName.setForeground(Color.WHITE);
        userFNameTXT = new JTextField(20);
        userFNameTXT.setFont(font2);
        userFNameTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (userFNameTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        userLName = new JLabel("User Last Name:", SwingConstants.CENTER);
        userLName.setFont(font2);
        userLName.setForeground(Color.WHITE);
        userLNameTXT = new JTextField(20);
        userLNameTXT.setFont(font2);
        userLNameTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (userLNameTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        userPassword = new JLabel("User Password:", SwingConstants.CENTER);
        userPassword.setFont(font2);
        userPassword.setForeground(Color.WHITE);
        userPasswordTXT = new JTextField(20);
        userPasswordTXT.setFont(font2);
        userPasswordTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (userPasswordTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        addingUser = new JButton("Add");
        addingUser.setFont(font2);
        addingUser.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 4));
        
        //Updating Product
        adminProductUpdatePanel = new JPanel();
        
        updateProductHeader = new JLabel("EDIT PRODUCT", SwingConstants.CENTER);
        updateProductHeader.setFont(font2);
        updateProductHeader.setForeground(Color.BLACK);
        
        setProduct = new JLabel("Select Product ID:", SwingConstants.CENTER);
        setProduct.setFont(font2);
        setProduct.setForeground(Color.WHITE);
        setProductComboBox = new JComboBox();
        setProductComboBox.setFont(font2);
        
        setProductComboBox.removeAllItems();
        setProductComboBox.addItem("--No item selected--");
        ArrayList<Product> products = new ArrayList();
        products = client.getAllProducts();
        for(Product ans : products){
            setProductComboBox.addItem(ans.getId());
        }
        
  
        updateProductName = new JLabel("Product Name:", SwingConstants.CENTER);
        updateProductName.setFont(font2);
        updateProductName.setForeground(Color.WHITE);
        updateProductNameTXT = new JTextField(20);
        updateProductNameTXT.setFont(font2);
        updateProductNameTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (updateProductNameTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        updateProductDes = new JLabel("Product Description:", SwingConstants.CENTER);
        updateProductDes.setFont(font2);
        updateProductDes.setForeground(Color.WHITE);
        updateProductDesTXT = new JTextField(20);
        updateProductDesTXT.setFont(font2);
        updateProductDesTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (updateProductDesTXT.getText().length() >= 50)
                {
                    e.consume();
                }
            }
        });
        
        updateProductCat = new JLabel("Product Category:", SwingConstants.CENTER);
        updateProductCat.setFont(font2);
        updateProductCat.setForeground(Color.WHITE);
        updateProductCatcomboBox = new JComboBox();
        updateProductCatcomboBox.setFont(font2);
        updateProductCatcomboBox.addItem("Other");
        updateProductCatcomboBox.addItem("Writing");
        updateProductCatcomboBox.addItem("Filing");
        updateProductCatcomboBox.addItem("Business");
        updateProductCatcomboBox.addItem("Drawing");
        updateProductCatcomboBox.addItem("Mailing");
        updateProductCatcomboBox.addItem("School");

        
        updateProductPrice = new JLabel("Product Price:", SwingConstants.CENTER);
        updateProductPrice.setFont(font2);
        updateProductPrice.setForeground(Color.WHITE);
        updateProductPriceTXT = new JTextField(20);
        updateProductPriceTXT.setFont(font2);
        
        updateProductQuan = new JLabel("Product Quantity:", SwingConstants.CENTER);
        updateProductQuan.setFont(font2);
        updateProductQuan.setForeground(Color.WHITE);
        updateProductQuanTXT = new JTextField(20);
        updateProductQuanTXT.setFont(font2);
        
        updatingProduct = new JButton("Update");
        updatingProduct.setFont(font2);
        updatingProduct.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 4));
        
        deletingProduct = new JButton("Delete");
        deletingProduct.setFont(font2);
        deletingProduct.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 4));
        
        //Updating User
        adminUserUpdatePanel = new JPanel();
        
        updateUserHeader = new JLabel("EDIT USER", SwingConstants.CENTER);
        updateUserHeader.setFont(font2);
        updateUserHeader.setForeground(Color.BLACK);
        
        setUser = new JLabel("Select User ID:", SwingConstants.CENTER);
        setUser.setFont(font2);
        setUser.setForeground(Color.WHITE);
        setUserComboBox = new JComboBox();
        setUserComboBox.setFont(font2);
        
        setUserComboBox.removeAllItems();
        setUserComboBox.addItem("--No item selected--");
        ArrayList<User> usersArray = new ArrayList();
        usersArray = client.getAllUsers();
        for(User ans : usersArray){
            setUserComboBox.addItem(ans.getId());
        }
        
        
       
        
        updateUserFName = new JLabel("User First Name:", SwingConstants.CENTER);
        updateUserFName.setFont(font2);
        updateUserFName.setForeground(Color.WHITE);
        updateUserFNameTXT = new JTextField(20);
        updateUserFNameTXT.setFont(font2);
        updateUserFNameTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (updateUserFNameTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        updateUserLName = new JLabel("User Last Name:", SwingConstants.CENTER);
        updateUserLName.setFont(font2);
        updateUserLName.setForeground(Color.WHITE);
        updateUserLNameTXT = new JTextField(20);
        updateUserLNameTXT.setFont(font2);
        updateUserLNameTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (updateUserLNameTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        updateUserPassword = new JLabel("User Password:", SwingConstants.CENTER);
        updateUserPassword.setFont(font2);
        updateUserPassword.setForeground(Color.WHITE);
        updateUserPasswordTXT = new JTextField(20);
        updateUserPasswordTXT.setFont(font2);
        updateUserPasswordTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (updateUserPasswordTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        updateUser = new JButton("Update");
        updateUser.setFont(font2);
        updateUser.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 4));
        
        deleteUser = new JButton("Delete");
        deleteUser.setFont(font2);
        deleteUser.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 4));
        
        //Admin table product view
        displayPanelProduct = new JPanel();
        displayPanelProduct.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Product Table", TitledBorder.LEFT,
                TitledBorder.TOP));
      
        String[] columnNamesProduct = {"ID", "NAME", "DESCRIPTION", "CATEGORY", "PRICE", "QUANTITY"};
        ArrayList<Product> tableArrayProducts = new ArrayList<>();
        tableArrayProducts = client.getAllProducts();
        DefaultTableModel modelProducts = new DefaultTableModel(columnNamesProduct, 0);
        for(int i = 0; i < tableArrayProducts.size(); i++) {
            
            Object[] objsProducts = {tableArrayProducts.get(i).getId(), tableArrayProducts.get(i).getName(), tableArrayProducts.get(i).getDescription(), 
                tableArrayProducts.get(i).getCategory(), tableArrayProducts.get(i).getPrice(), tableArrayProducts.get(i).getQuantity()};
            modelProducts.addRow(objsProducts);
        }
        
        TableProduct = new JTable();
        TableProduct.setModel(modelProducts);
        
        
        productScroll = new JScrollPane();
        
        productScroll.setViewportView(TableProduct);
        
        
        //Admin user table view
        displayPanelUser = new JPanel();
        displayPanelUser.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "User Table", TitledBorder.LEFT,
                TitledBorder.TOP));
      
        String[] columnNamesUser = {"ID", "FIRST NAME", "LAST NAME", "PASSWORD", "ACTIVE"};
        ArrayList<User> tableArrayUser = new ArrayList<>();
        tableArrayUser = client.getAllUsers();
        DefaultTableModel modelUser = new DefaultTableModel(columnNamesUser, 0);
        for(int i = 0; i < tableArrayUser.size(); i++) {
            
            Object[] objsUser = {tableArrayUser.get(i).getId(), tableArrayUser.get(i).getfName(), tableArrayUser.get(i).getlName(), 
                tableArrayUser.get(i).getPassword(), tableArrayUser.get(i).isActive()};
            
            modelUser.addRow(objsUser);
        }
        
        TableUser = new JTable();
        TableUser.setModel(modelUser);
  
        userScroll = new JScrollPane();
        
        userScroll.setViewportView(TableUser);
        
        //Logout Panel
        logoutPanel = new JPanel();
        logoutAdmin = new JButton("Logout");
        logoutAdmin.setFont(font2);
        logoutAdmin.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 4));
        
        //Adding background color for admin
        adminTitlePanel.setBackground(new Color(0, 153, 237));
        adminBodyPanel.setBackground(new Color(0, 153, 237));
        adminProductPanel.setBackground(new Color(44, 165, 232));
        adminUserPanel.setBackground(new Color(0, 153, 237));
        adminProductUpdatePanel.setBackground(new Color(0, 153, 237));
        adminUserUpdatePanel.setBackground(new Color(44, 165, 232));
        displayPanelProduct.setBackground(new Color(44, 165, 232));
        displayPanelUser.setBackground(new Color(0, 153, 237));
        logoutPanel.setBackground(new Color(0, 153, 237));
        
        //---------------------------------------------------------------------------------------
        
        //User
        
        //Setting user frame
        userFrame = new JFrame("User");
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //User title panel
        userTitlePanel = new JPanel();
        userTitlePanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        userTitle = new JLabel("User", SwingConstants.CENTER);
        userTitle.setForeground(Color.WHITE);
        userTitle.setFont(font3);
        userTitle.setBorder(new EmptyBorder(10, 0, 10, 0));

        //User body panel
        userBodyPanel = new JPanel();
        font2 = new Font("Dialog", Font.BOLD, 16);
        
        //Adding Customer
        userCustomerPanel = new JPanel();
        
        customerHeader = new JLabel("ADD CUSTOMER", SwingConstants.CENTER);
        customerHeader.setFont(font2);
        customerHeader.setForeground(Color.BLACK);
        
        customerID = new JLabel("Customer ID:", SwingConstants.CENTER);
        customerID.setFont(font2);
        customerID.setForeground(Color.WHITE);
        customerIDTXT = new JTextField(20);
        customerIDTXT.setFont(font2);
        customerIDTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (customerIDTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        customerFName = new JLabel("Customer First Name:", SwingConstants.CENTER);
        customerFName.setFont(font2);
        customerFName.setForeground(Color.WHITE);
        customerFNameTXT = new JTextField(20);
        customerFNameTXT.setFont(font2);
        customerFNameTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (customerFNameTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        customerLName = new JLabel("Customer First Name:", SwingConstants.CENTER);
        customerLName.setFont(font2);
        customerLName.setForeground(Color.WHITE);
        customerLNameTXT = new JTextField(20);
        customerLNameTXT.setFont(font2);
        customerLNameTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (customerLNameTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        addingCustomer = new JButton("Add");
        addingCustomer.setFont(font2);
        addingCustomer.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 4));
        
        //User customer table view
        displayPanelCustomer = new JPanel();
        displayPanelCustomer.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Customer Table", TitledBorder.LEFT,
                TitledBorder.TOP));
      
        String[] columnNamesCustomer = {"ID", "FIRST NAME", "LAST NAME"};
        ArrayList<Customer> tableArrayCustomer = new ArrayList<>();
        tableArrayCustomer = client.getAllCustomers();
        DefaultTableModel modelCustomer = new DefaultTableModel(columnNamesCustomer, 0);
        for(int i = 0; i < tableArrayCustomer.size(); i++) {
            
            Object[] objsCustomer = {tableArrayCustomer.get(i).getId(), tableArrayCustomer.get(i).getFname(), tableArrayCustomer.get(i).getLname(),};
            
            modelCustomer.addRow(objsCustomer);
        }
        
        TableCustomer = new JTable();
        TableCustomer.setModel(modelCustomer);
  
        customerScroll = new JScrollPane();
        
        customerScroll.setViewportView(TableCustomer);
        
        
        //Customer transaction
        userTransactionPanel = new JPanel();
        
        transactionHeader = new JLabel("PURCHASE PRODUCTS", SwingConstants.CENTER);
        transactionHeader.setFont(font2);
        transactionHeader.setForeground(Color.BLACK);
        
        setUserCustomer = new JLabel("Select Customer ID:", SwingConstants.CENTER);
        setUserCustomer.setFont(font2);
        setUserCustomer.setForeground(Color.WHITE);
        setCustomerComboBox = new JComboBox();
        setCustomerComboBox.setFont(font2);
        
        setCustomerComboBox.removeAllItems();
        setCustomerComboBox.addItem("--No item selected--");
        
        ArrayList<Customer> customerArray = new ArrayList();
        customerArray = client.getAllCustomers();
        
        Collections.sort(customerArray, (p1, p2) -> p1.getFname().compareTo(p2.getFname()));
        
        for(Customer ans : customerArray){
            setCustomerComboBox.addItem(ans.getId());
        }
        
        setUserProduct = new JLabel("Select Product ID:", SwingConstants.CENTER);
        setUserProduct.setFont(font2);
        setUserProduct.setForeground(Color.WHITE);
        setUserProductComboBox = new JComboBox();
        setUserProductComboBox.setFont(font2);
        
        setUserProductComboBox.removeAllItems();
        setUserProductComboBox.addItem("--No item selected--");
        
        ArrayList<Product> userProductArray = new ArrayList();
        userProductArray = client.getAllProducts();
        
        Collections.sort(userProductArray, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        
        for(Product ans : userProductArray){
            setUserProductComboBox.addItem(ans.getId());
        }
        
        productAmount = new JLabel("Product Amount:", SwingConstants.CENTER);
        productAmount.setFont(font2);
        productAmount.setForeground(Color.WHITE);
        productAmountTXT = new JTextField(20);
        productAmountTXT.setFont(font2);
        productAmountTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (productAmountTXT.getText().length() >= 10)
                {
                    e.consume();
                }
            }
        });
        
        addingTransaction = new JButton("Add");
        addingTransaction.setFont(font2);
        addingTransaction.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 4));
        
        //User transaction table view
        displayPanelTransaction = new JPanel();
        displayPanelTransaction.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Transaction Table                                                                                         Product Amount Table", TitledBorder.LEFT,
                TitledBorder.TOP));

        //Transactions
        String[] columnNamesTransaction = {"ID", "CUSTOMER ID", "PRODUCT ID", "AMOUNT"};
        ArrayList<Transaction> tableArrayTransaction = new ArrayList<>();
        tableArrayTransaction = client.getAllTransactions();
        DefaultTableModel modelTransaction = new DefaultTableModel(columnNamesTransaction, 0);
        for(int i = 0; i < tableArrayTransaction.size(); i++) {
            
            Object[] objsTransaction = {tableArrayTransaction.get(i).getId(), tableArrayTransaction.get(i).getCustomerID(), tableArrayTransaction.get(i).getProductID(),
            tableArrayTransaction.get(i).getAmount()};
            
            modelTransaction.addRow(objsTransaction);
        }
         
        TableTransaction1 = new JTable();
        TableTransaction1.setModel(modelTransaction);
        transactionScroll = new JScrollPane();
        transactionScroll.setViewportView(TableTransaction1);
        
        //Products
        String[] columnNamesTransactionPro = {"ID", "NAME", "DESCRIPTION", "CATEGORY", "PRICE", "QUANTITY"};
        ArrayList<Product> tableArrayTransactionPro = new ArrayList<>();
        tableArrayTransactionPro = client.getAllProducts();
        
        Collections.sort(tableArrayTransactionPro, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        
        DefaultTableModel modelTransactionPro = new DefaultTableModel(columnNamesTransactionPro, 0);
        for(int i = 0; i < tableArrayTransactionPro.size(); i++) {
            
            Object[] objsTransactionPro = {tableArrayTransactionPro.get(i).getId(), tableArrayTransactionPro.get(i).getName(), tableArrayTransactionPro.get(i).getDescription(),
            tableArrayTransactionPro.get(i).getCategory(), tableArrayTransactionPro.get(i).getPrice(), tableArrayTransactionPro.get(i).getQuantity()};
            
            modelTransactionPro.addRow(objsTransactionPro);
        }
        
        TableTransactionProducts = new JTable();
        TableTransactionProducts.setModel(modelTransactionPro);
        userProductsScroll = new JScrollPane();
        userProductsScroll.setViewportView(TableTransactionProducts);        
        
        
        //Customer transaction panel
        customerTransaction = new JPanel();
        
        customerTransactionHeader = new JLabel("CUSTOMER TRANSACTIONS", SwingConstants.CENTER);
        customerTransactionHeader.setFont(font2);
        customerTransactionHeader.setForeground(Color.BLACK);
        
        setCustomerTransactions = new JLabel("Select Customer ID:", SwingConstants.CENTER);
        setCustomerTransactions.setFont(font2);
        setCustomerTransactions.setForeground(Color.WHITE);
        setCustomerTransactionComboBox = new JComboBox();
        setCustomerTransactionComboBox.setFont(font2);
        
        setCustomerTransactionComboBox.removeAllItems();
        setCustomerTransactionComboBox.addItem("--No item selected--");
        
        ArrayList<Customer> customerTransactionArray = new ArrayList();
        customerTransactionArray = client.getAllCustomers();
        
        Collections.sort(customerTransactionArray, (p1, p2) -> p1.getFname().compareTo(p2.getFname()));
        
        for(Customer ans : customerTransactionArray){
            setCustomerTransactionComboBox.addItem(ans.getId());
        }
        
         //Customer transactions table
        customerTransactionDisplayPanel = new JPanel();
        customerTransactionDisplayPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Customer Transactions Table", TitledBorder.LEFT,
                TitledBorder.TOP));
         
        String[] customerTransactionsNames = {"ID", "CUSTOMER ID", "PRODUCT ID", "AMOUNT"};
        ArrayList<Transaction> tableArrayTransactionCustomer = new ArrayList<>();
        
        
        Collections.sort(tableArrayTransactionCustomer, (p1, p2) -> p1.getId().compareTo(p2.getId()));
        
        modelTransactionCustomer = new DefaultTableModel(customerTransactionsNames, 0);
        for(int i = 0; i < tableArrayTransactionCustomer.size(); i++) {
            
            Object[] objsTransactionCustomer = {tableArrayTransactionCustomer.get(i).getId(), tableArrayTransactionCustomer.get(i).getCustomerID(), 
                tableArrayTransactionCustomer.get(i).getProductID(),
            tableArrayTransactionCustomer.get(i).getAmount()};
            
            modelTransactionCustomer.addRow(objsTransactionCustomer);
        }
        
        TableTransactionCustomer = new JTable();
        TableTransactionCustomer.setModel(modelTransactionCustomer);
        userTransactionCusScroll = new JScrollPane();
        userTransactionCusScroll.setViewportView(TableTransactionCustomer);    
        
        
        
        
        
        
        //Logout and sales report
        userSouthPanel = new JPanel();
        userSouthPanel.setBorder(new EmptyBorder(0,0,0,0));
        
               
        String[] salesReportCol = {"PRODUCT", "PRODUCT PRICE", "AMOUNT SOLD", "SUB TOTAL"};
           
        ArrayList<Transaction> salesTransactions = new ArrayList<>();
        salesTransactions = client.getAllTransactions();
        
        ArrayList<Product> salesProducts = new ArrayList<>();
        salesProducts = client.getAllProducts();
        
        ArrayList<SalesReport> salesReports = new ArrayList<>();
        
        for(Product ans : salesProducts){
            salesReports.add(new SalesReport(ans.getId(), ans.getName(), ans.getPrice()));
        }
        
        for(Transaction ans : salesTransactions){
            for(SalesReport ans2 : salesReports){
                if(ans.getProductID().equals(ans2.getId())){
                    ans2.setAmount(ans2.getAmount() + ans.getAmount());
                }
            }
        }
        
        for(SalesReport ans : salesReports){
            ans.setTotal((int) (ans.getAmount() * ans.getProductPrice()));
        }
        
        
        Collections.sort(salesReports, (p1, p2) -> p1.getProduct().compareTo(p2.getProduct()));
        
        DefaultTableModel modelTransactionSales = new DefaultTableModel(salesReportCol, 0);
        for(int i = 0; i < salesReports.size(); i++) {
            
            Object[] objsTransactionCustomer = {salesReports.get(i).getProduct(), salesReports.get(i).getProductPrice(), 
                salesReports.get(i).getAmount(),
            salesReports.get(i).getTotal()};
            
            modelTransactionSales.addRow(objsTransactionCustomer);
        }
        
        TableTransactionSales = new JTable();
        TableTransactionSales.setModel(modelTransactionSales);
        userTransactionSalesScroll = new JScrollPane();
        userTransactionSalesScroll.setViewportView(TableTransactionSales); 
        
        salesReportPane = new JPanel();
        salesReportPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Sub-Total for Products Table", TitledBorder.LEFT,
                TitledBorder.TOP));
        
        
        salesReportHeader = new JLabel("SALES REPORT", SwingConstants.CENTER);
        salesReportHeader.setFont(font2);
        salesReportHeader.setForeground(Color.BLACK);
        
        logoutPanelUser = new JPanel();
        logoutUser = new JButton("Logout");
        logoutUser.setFont(font2);
        logoutUser.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 4));
        

        
        salesReportTotal = new JLabel("Sales report Total: ", SwingConstants.CENTER);
        salesReportTotal.setFont(font2);
        salesReportTotal.setForeground(Color.WHITE);
        
        
        int totalSalesRepport = 0;
         for(SalesReport ans : salesReports){
           totalSalesRepport = totalSalesRepport + ans.getTotal() ;
        }
        
  
        
        salesReportTotal2 = new JTextField(20);
        salesReportTotal2.setText("" + totalSalesRepport);
        salesReportTotal2.setFont(font2);
        salesReportTotal2.setEditable(false);
        
        
        //Adding background color for USER
        userTitlePanel.setBackground(new Color(0, 153, 237));
        userCustomerPanel.setBackground(new Color(44, 165, 232));
        displayPanelCustomer.setBackground(new Color(0, 153, 237));
        userProductsScroll.setBackground(new Color(44, 165, 232));
        transactionScroll.setBackground(new Color(44, 165, 232));
        displayPanelTransaction.setBackground(new Color(44, 165, 232));
        userTransactionPanel.setBackground(new Color(0, 153, 237));
        customerTransaction.setBackground(new Color(44, 165, 232));
        customerTransactionDisplayPanel.setBackground(new Color(0, 153, 237));
        logoutPanelUser.setBackground(new Color(0, 153, 237));
        userSouthPanel.setBackground(new Color(0, 153, 237));
        salesReportPane.setBackground(new Color(44, 165, 232));
    }
    
    public void setGUI() {
        
        //Adding title to loginPanel
        loginTitlePanel.add(loginTitle);
        
        //Adding elements to loginBody
        loginBodyPanel.setLayout(new GridLayout(5,3));
        loginBodyPanel.add(new JLabel(""));
        loginBodyPanel.add(new JLabel(""));
        loginBodyPanel.add(new JLabel(""));

        loginBodyPanel.add(employeeID);
        loginBodyPanel.add(employeeIDTXT);
        loginBodyPanel.add(new JLabel(""));
        
        loginBodyPanel.add(new JLabel(""));
        loginBodyPanel.add(new JLabel(""));
        loginBodyPanel.add(new JLabel(""));
        
        loginBodyPanel.add(employeePassword);
        loginBodyPanel.add(employeePasswordTXT);
        loginBodyPanel.add(new JLabel(""));
      
        loginBodyPanel.add(new JLabel(""));
        loginBodyPanel.add(new JLabel(""));
        loginBodyPanel.add(new JLabel(""));
        
        //Adding elements to loginButtonPanel
        loginButtonPanel.setLayout(new GridLayout(1,2));
        loginButtonPanel.add(adminLogin);
        loginButtonPanel.add(userLogin);
        
        //Adding panels to loginFrame        
        loginFrame.add(loginTitlePanel, BorderLayout.NORTH);
        loginFrame.add(loginBodyPanel, BorderLayout.CENTER);
        loginFrame.add(loginButtonPanel, BorderLayout.SOUTH);
        
        //Adding actionListener to buttons
        adminLogin.addActionListener(this);
        userLogin.addActionListener(this);
        addingProduct.addActionListener(this);
        addingUser.addActionListener(this);
        updatingProduct.addActionListener(this);
        deletingProduct.addActionListener(this);
        updateUser.addActionListener(this);
        deleteUser.addActionListener(this);
        setProductComboBox.addItemListener(this);
        setUserComboBox.addItemListener(this);
        logoutAdmin.addActionListener(this);
        addingCustomer.addActionListener(this);
        addingTransaction.addActionListener(this);
        setCustomerTransactionComboBox.addItemListener(this);
        logoutUser.addActionListener(this);
        
        
        //Setting of start values for login
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
        
        //---------------------------------------------------------------------------------------
        
        //Adding title to adminPanel
        adminTitlePanel.add(adminTitle);
        
        
        //Adding elements to adminProductPanel
        adminProductPanel.setLayout(new GridLayout(9,3));
        adminProductPanel.add(new JLabel(""));
        adminProductPanel.add(productHeader);
        adminProductPanel.add(new JLabel(""));
        
        adminProductPanel.add(productID);
        adminProductPanel.add(productIDTXT);
        adminProductPanel.add(new JLabel(""));
        
        adminProductPanel.add(productName);
        adminProductPanel.add(productNameTXT);
        adminProductPanel.add(new JLabel(""));
        
        adminProductPanel.add(productDes);
        adminProductPanel.add(productDesTXT);
        adminProductPanel.add(new JLabel(""));
        
        adminProductPanel.add(productCat);
        adminProductPanel.add(productCatcomboBox);
        adminProductPanel.add(new JLabel(""));
        
        adminProductPanel.add(productPrice);
        adminProductPanel.add(productPriceTXT);
        adminProductPanel.add(new JLabel(""));
        
        adminProductPanel.add(productQuan);
        adminProductPanel.add(productQuanTXT);
        adminProductPanel.add(new JLabel(""));
        
        adminProductPanel.add(addingProduct);
        adminProductPanel.add(new JLabel(""));
        adminProductPanel.add(new JLabel(""));
        
        adminProductPanel.add(new JLabel(""));
        adminProductPanel.add(new JLabel(""));
        adminProductPanel.add(new JLabel(""));
        
        //Adding elements to adminUserPanel
        adminUserPanel.setLayout(new GridLayout(7,2));
        adminUserPanel.add(new JLabel(""));
        adminUserPanel.add(userHeader);
        
        
        adminUserPanel.add(userID);
        adminUserPanel.add(userIDTXT);
        
        
        adminUserPanel.add(userFName);
        adminUserPanel.add(userFNameTXT);
        
        
        adminUserPanel.add(userLName);
        adminUserPanel.add(userLNameTXT);
        
        
        adminUserPanel.add(userPassword);
        adminUserPanel.add(userPasswordTXT);
        
        
        adminUserPanel.add(addingUser);
        adminUserPanel.add(new JLabel(""));
        
        adminUserPanel.add(new JLabel(""));
        adminUserPanel.add(new JLabel(""));
        
        
        //Adding elements to adminProductUpdatePanel
        adminProductUpdatePanel.setLayout(new GridLayout(8,3));
        
        adminProductUpdatePanel.add(new JLabel(""));
        adminProductUpdatePanel.add(updateProductHeader);
        adminProductUpdatePanel.add(new JLabel(""));
        
        adminProductUpdatePanel.add(setProduct);
        adminProductUpdatePanel.add(setProductComboBox);
        adminProductUpdatePanel.add(new JLabel(""));
        
        
        adminProductUpdatePanel.add(updateProductName);
        adminProductUpdatePanel.add(updateProductNameTXT);
        adminProductUpdatePanel.add(new JLabel(""));
        
        adminProductUpdatePanel.add(updateProductDes);
        adminProductUpdatePanel.add(updateProductDesTXT);
        adminProductUpdatePanel.add(new JLabel(""));
        
        adminProductUpdatePanel.add(updateProductCat);
        adminProductUpdatePanel.add(updateProductCatcomboBox);
        adminProductUpdatePanel.add(new JLabel(""));
        
        adminProductUpdatePanel.add(updateProductPrice);
        adminProductUpdatePanel.add(updateProductPriceTXT);
        adminProductUpdatePanel.add(new JLabel(""));
        
        adminProductUpdatePanel.add(updateProductQuan);
        adminProductUpdatePanel.add(updateProductQuanTXT);
        adminProductUpdatePanel.add(new JLabel(""));
        
        
        adminProductUpdatePanel.add(updatingProduct);
        adminProductUpdatePanel.add(deletingProduct);
        adminProductUpdatePanel.add(new JLabel(""));
        
        //Adding elements to adminUserUpdatePanel
        adminUserUpdatePanel.setLayout(new GridLayout(6,2));
        
        adminUserUpdatePanel.add(new JLabel(""));
        adminUserUpdatePanel.add(updateUserHeader);
        
        
        adminUserUpdatePanel.add(setUser);
        adminUserUpdatePanel.add(setUserComboBox);
        

        
        
        adminUserUpdatePanel.add(updateUserFName);
        adminUserUpdatePanel.add(updateUserFNameTXT);
        
        
        adminUserUpdatePanel.add(updateUserLName);
        adminUserUpdatePanel.add(updateUserLNameTXT);
       
        
        adminUserUpdatePanel.add(updateUserPassword);
        adminUserUpdatePanel.add(updateUserPasswordTXT);
        
        adminUserUpdatePanel.add(updateUser);
        adminUserUpdatePanel.add(deleteUser);
        
        //Adding elemetns to tables
        displayPanelProduct.add(productScroll);
        displayPanelUser.add(userScroll);
        
        //Logout Button
        logoutPanel.add(logoutAdmin);
        
        //Addinge panels to admin body panel 
        adminBodyPanel.setLayout(new GridLayout(3,2));
        adminBodyPanel.add(adminProductPanel);
        adminBodyPanel.add(adminUserPanel);
        adminBodyPanel.add(adminProductUpdatePanel);
        adminBodyPanel.add(adminUserUpdatePanel);
        adminBodyPanel.add(displayPanelProduct);
        adminBodyPanel.add(displayPanelUser);
        
        //Adding panels to adminFrame        
        adminFrame.add(adminTitlePanel, BorderLayout.NORTH);
        adminFrame.add(adminBodyPanel, BorderLayout.CENTER);
        adminFrame.add(logoutPanel, BorderLayout.SOUTH);
        
        
        //---------------------------------------------------------------------------------------
        
        //Adding title to userPanel
        userTitlePanel.add(userTitle);
        
        //Adding elements to user customer panel
        userCustomerPanel.setLayout(new GridLayout(5,3));
        
        userCustomerPanel.add(new JLabel(""));
        userCustomerPanel.add(customerHeader);
        userCustomerPanel.add(new JLabel(""));
        
        userCustomerPanel.add(customerID);
        userCustomerPanel.add(customerIDTXT);
        userCustomerPanel.add(new JLabel(""));
        
        userCustomerPanel.add(customerFName);
        userCustomerPanel.add(customerFNameTXT);
        userCustomerPanel.add(new JLabel(""));
        
        userCustomerPanel.add(customerLName);
        userCustomerPanel.add(customerLNameTXT);
        userCustomerPanel.add(new JLabel(""));
        
        userCustomerPanel.add(addingCustomer);
        userCustomerPanel.add(new JLabel(""));
        userCustomerPanel.add(new JLabel(""));
        
        
        displayPanelCustomer.add(customerScroll);
        
        //Adding elements to user transaction panel
        userTransactionPanel.setLayout(new GridLayout(5,3));
        
        userTransactionPanel.add(new JLabel(""));
        userTransactionPanel.add(transactionHeader);
        userTransactionPanel.add(new JLabel(""));
        
        userTransactionPanel.add(setUserCustomer);
        userTransactionPanel.add(setCustomerComboBox);
        userTransactionPanel.add(new JLabel(""));
        
        userTransactionPanel.add(setUserProduct);
        userTransactionPanel.add(setUserProductComboBox);
        userTransactionPanel.add(new JLabel(""));
        
        userTransactionPanel.add(productAmount);
        userTransactionPanel.add(productAmountTXT);
        userTransactionPanel.add(new JLabel(""));
        
        userTransactionPanel.add(addingTransaction);
        userTransactionPanel.add(new JLabel(""));
        userTransactionPanel.add(new JLabel(""));
        
         //Adding elements to user customer transaction panel
        customerTransaction.setLayout(new GridLayout(3,3));
        
        customerTransaction.add(new JLabel(""));
        customerTransaction.add(customerTransactionHeader);
        customerTransaction.add(new JLabel(""));
        
        customerTransaction.add(setCustomerTransactions);
        customerTransaction.add(setCustomerTransactionComboBox);
        customerTransaction.add(new JLabel(""));
        
        customerTransaction.add(new JLabel(""));
        customerTransaction.add(new JLabel(""));
        customerTransaction.add(new JLabel(""));

        //Adding elemetns to tables
        displayPanelTransaction.setLayout(new GridLayout(1,2));
        displayPanelTransaction.add(transactionScroll);
        displayPanelTransaction.add(userProductsScroll);
        
        
        //Customer transactions table
        customerTransactionDisplayPanel.add(userTransactionCusScroll);

       
        //Sales report textfields
        userSouthPanel.setLayout(new GridLayout(3, 3));

        userSouthPanel.add(new JLabel(""));
        userSouthPanel.add(salesReportHeader);
        userSouthPanel.add(new JLabel(""));

        userSouthPanel.add(salesReportTotal);
        userSouthPanel.add(salesReportTotal2);
        userSouthPanel.add(new JLabel(""));

        userSouthPanel.add(new JLabel(""));
        userSouthPanel.add(new JLabel(""));
        userSouthPanel.add(new JLabel(""));


        //Sales report table
        salesReportPane.add(userTransactionSalesScroll);
       
        //Logout button
        logoutPanelUser.add(logoutUser);
        
        //Adding elements to userBodyPanel
        userBodyPanel.setLayout(new GridLayout(4,2));
        userBodyPanel.add(userCustomerPanel);
        userBodyPanel.add(displayPanelCustomer);
        userBodyPanel.add(userTransactionPanel);
        userBodyPanel.add(displayPanelTransaction);
        userBodyPanel.add(customerTransaction);
        userBodyPanel.add(customerTransactionDisplayPanel);
        userBodyPanel.add(userSouthPanel);
        userBodyPanel.add(salesReportPane);
        
        //Adding panels to usrFrame       
        userFrame.add(userTitlePanel, BorderLayout.NORTH);
        userFrame.add(userBodyPanel, BorderLayout.CENTER);
        userFrame.add(logoutPanelUser, BorderLayout.SOUTH);
        
 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminLogin) {
            if (employeeIDTXT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in your ID");
            } else if (employeePasswordTXT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in your Password");
            } else {
                Boolean adminValue = client.login("adminLogin", employeeIDTXT.getText(), employeePasswordTXT.getText());
                if (adminValue) {
                    loginFrame.setVisible(false);
                    adminFrame.setSize(1500, 1000);
                    adminFrame.setLocationRelativeTo(null);
                    adminFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect login details for admin");
                }
            }
        }
        
        if (e.getSource() == userLogin) {

            ArrayList<User> userArray = new ArrayList();
            userArray = client.getAllUsers(); 
            
            boolean isActive = true;
            for (User ans : userArray) {
                if (ans.getId().equals(employeeIDTXT.getText())) {
                    isActive = ans.isActive();
                }
            }

            if (employeeIDTXT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in your ID");
            } else if (employeePasswordTXT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in your Password");
            } else {
                Boolean userValue = client.login("userLogin", employeeIDTXT.getText(), employeePasswordTXT.getText());
                if (userValue) {
                    if (!isActive) {
                        JOptionPane.showMessageDialog(null, "User account has been disabled");
                    } else {
                        loginFrame.setVisible(false);
                        userFrame.setSize(1500, 1000);
                        userFrame.setLocationRelativeTo(null);
                        userFrame.setVisible(true);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect login details for user");
                }
            }
        }

        if (e.getSource() == logoutAdmin) {

            adminFrame.setVisible(false);
            loginFrame.pack();
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setVisible(true);
            employeeIDTXT.setText("");
            employeePasswordTXT.setText("");

        }
        
         if (e.getSource() == logoutUser) {

            userFrame.setVisible(false);
            loginFrame.pack();
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setVisible(true);
            employeeIDTXT.setText("");
            employeePasswordTXT.setText("");

        }
       
        if (e.getSource() == addingProduct) {
            if (productIDTXT.getText().isEmpty() || productNameTXT.getText().isEmpty() || productDesTXT.getText().isEmpty()
                    || productPriceTXT.getText().isEmpty() || productQuanTXT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all required columns");
            } else {
                
                String id = productIDTXT.getText();
                String name = productNameTXT.getText();
                String des = productDesTXT.getText();
                String cat = (String) productCatcomboBox.getSelectedItem();              
                double price = Double.parseDouble(productPriceTXT.getText()); 
                int quan  = Integer.parseInt(productQuanTXT.getText());
                   
                Boolean userValue = client.addProduct(id, name, des, cat, price, quan);
                if (userValue) {
                    this.refreshAdmin();
                    JOptionPane.showMessageDialog(null, "Success, product added to database");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add product to database");
                }
            }
        }
        
        if (e.getSource() == addingUser) {
            if (userIDTXT.getText().isEmpty() || userFNameTXT.getText().isEmpty() || userLNameTXT.getText().isEmpty()
                    || userPasswordTXT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all required columns");
            } else {
                
                String id = userIDTXT.getText();
                String firstName = userFNameTXT.getText();
                String lastName = userLNameTXT.getText();
                String password = userPasswordTXT.getText();
                   
                Boolean userValue = client.addUser(id, firstName, lastName, password);
                if (userValue) {
                    this.refreshAdmin();
                    JOptionPane.showMessageDialog(null, "Success, user added to database");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add user to database");
                }
            }
        }
        
        if (e.getSource() == updatingProduct) {
            if (updateProductNameTXT.getText().isEmpty() || updateProductDesTXT.getText().isEmpty()
                    || updateProductPriceTXT.getText().isEmpty() || updateProductQuanTXT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all required columns");
            } else {
                
                String id = (String) setProductComboBox.getSelectedItem();
                String name = updateProductNameTXT.getText();
                String des = updateProductDesTXT.getText();
                String cat = (String) updateProductCatcomboBox.getSelectedItem();              
                double price = Double.parseDouble(updateProductPriceTXT.getText()); 
                int quan  = Integer.parseInt(updateProductQuanTXT.getText());
                   
                Boolean userValue = client.editProduct(id, name, des, cat, price, quan);
                if (userValue) {
                    this.refreshAdmin();
                    JOptionPane.showMessageDialog(null, "Success, product edited");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to edit product");
                }
            }
        }
          
        if (e.getSource() == deletingProduct) {
            String value = (String)setProductComboBox.getSelectedItem();
            if (value.equals("--No item selected--")) {
                JOptionPane.showMessageDialog(null, "Please select a product");
            } else {
                
                String id = (String) setProductComboBox.getSelectedItem();
                
                   
                Boolean userValue = client.deleteProduct(id);
                if (userValue) {
                    this.refreshAdmin();
                    JOptionPane.showMessageDialog(null, "Success, product deleted");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete product");
                }
            }
        }
        
        
        if (e.getSource() == updateUser) {
            if (updateUserFNameTXT.getText().isEmpty() || updateUserLNameTXT.getText().isEmpty()
                    || updateUserPasswordTXT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all required columns");
            } else {
                
                String id = (String) setUserComboBox.getSelectedItem();
                String fname = updateUserFNameTXT.getText();
                String lname = updateUserLNameTXT.getText();
                String password = updateUserPasswordTXT.getText();
                   
                Boolean userValue = client.editUser(id, fname, lname, password);
                if (userValue) {
                    this.refreshAdmin();
                    JOptionPane.showMessageDialog(null, "Success, user edited");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to edit user");
                }
            }
        }
        
        if (e.getSource() == deleteUser) {
            String value = (String) setUserComboBox.getSelectedItem();
            if (value.equals("--No item selected--")) {
                JOptionPane.showMessageDialog(null, "Please select a user");
            } else {

                ArrayList<User> array = new ArrayList();
                array = client.getAllUsers();
                for (User var : array) {
                    if (var.getId().equals(value)){
                        if(var.isActive()){
                             client.deleteUser(value);
                             this.refreshAdmin();
                             JOptionPane.showMessageDialog(null, "Success, user account disabled");
                        } else {
                             JOptionPane.showMessageDialog(null, "User account is already disabled");
                        }
                       
                        
                    }

                }
            }

        }
        
        if (e.getSource() == addingCustomer) {
            if (customerIDTXT.getText().isEmpty() || customerFNameTXT.getText().isEmpty() || customerLNameTXT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all required columns");
            } else {
                
                String id = customerIDTXT.getText();
                String fname = customerFNameTXT.getText();
                String lname = customerLNameTXT.getText();
                
                   
                Boolean userValue = client.addCustomer(id, fname, lname);
                if (userValue) {
                    this.refreshAdmin();
                    JOptionPane.showMessageDialog(null, "Success, customer added to database");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add customer to database");
                }
            }
        }
  
        if (e.getSource() == addingTransaction) {
            
            int productAmountValue = Integer.valueOf(productAmountTXT.getText());
            
            if (setCustomerComboBox.getSelectedItem().equals("--No item selected--") || setUserProductComboBox.getSelectedItem().equals("--No item selected--")) {
                JOptionPane.showMessageDialog(null, "Please select an appropriate Customer and Product");
            } else if (productAmountTXT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in the amount");
            } else if (productAmountValue <= 0) {
                JOptionPane.showMessageDialog(null, "Please give an amount greater than 0");
            } else {

                String customerIDTransaction = (String) setCustomerComboBox.getSelectedItem();
                String productIDTransaction = (String) setUserProductComboBox.getSelectedItem();
                

                ArrayList<Product> arrayProducts = new ArrayList();
                arrayProducts = client.getAllProducts();

                
                for (Product ans : arrayProducts) {
                    if (ans.getId().equals(productIDTransaction)) {
                        if (ans.getQuantity() < productAmountValue) {
                            JOptionPane.showMessageDialog(null, "Not enough products in stock to complete transaction");
                        } else {
                            Boolean userValue = client.addTransaction(customerIDTransaction, productIDTransaction, productAmountValue);
                            if (userValue) {
                                
                                this.refreshAdmin();
                                JOptionPane.showMessageDialog(null, "Success, transaction completed");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to complete transaction");
                            }
                        }
                    }
                }

            }
        }

    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            
            if (e.getSource().equals(setProductComboBox)) {
                String ans = (String) setProductComboBox.getSelectedItem();
                if (ans.equals("--No item selected--")) {
                    updateProductNameTXT.setText("");
                    updateProductDesTXT.setText("");
                    updateProductCatcomboBox.setSelectedItem("Other");
                    updateProductPriceTXT.setText("");
                    updateProductQuanTXT.setText("");
                } else {
                    String value = (String) setProductComboBox.getSelectedItem();
                    ArrayList<Product> array;

                    array = client.getAllProducts();
                    for (Product var : array) {
                        if (var.getId().equals(value)) {
                            updateProductNameTXT.setText(var.getName());
                            updateProductDesTXT.setText(var.getDescription());
                            updateProductCatcomboBox.setSelectedItem(var.getCategory());
                            updateProductPriceTXT.setText(String.valueOf(var.getPrice()));
                            updateProductQuanTXT.setText(String.valueOf(var.getQuantity()));
                        }
                    }
                }

            }
            
            if (e.getSource().equals(setUserComboBox)) {
                String ans = (String) setUserComboBox.getSelectedItem();
                if (ans.equals("--No item selected--")) {
                    updateUserFNameTXT.setText("");
                    updateUserLNameTXT.setText("");
                    updateUserPasswordTXT.setText("");
  
                } else {
                    String value = (String) setUserComboBox.getSelectedItem();
                    ArrayList<User> array;

                    array = client.getAllUsers();
                    for (User var : array) {
                        if (var.getId().equals(value)) {
                            updateUserFNameTXT.setText(var.getfName());
                            updateUserLNameTXT.setText(var.getlName());
                            updateUserPasswordTXT.setText(var.getPassword());
                        }
                    }
                }

            }

            if (e.getSource().equals(setCustomerTransactionComboBox)) {
                String ans = (String) setCustomerTransactionComboBox.getSelectedItem();
                if (ans.equals("--No item selected--")) {
                    
                    int rowsToRemove = modelTransactionCustomer.getRowCount();
                    for (int i = rowsToRemove - 1; i >= 0; i--) {
                        modelTransactionCustomer.removeRow(i);
                    }

                } else {
                    
                    ArrayList<Transaction> notFormatted = new ArrayList();
                    ArrayList<Transaction> isFormatted = new ArrayList();
                    
                    notFormatted = client.getAllTransactions();
                    
                    for(Transaction value : notFormatted){
                        if(value.getCustomerID().equals(ans)){
                            isFormatted.add(value);
                        }
                    }
                    
                    Collections.sort(isFormatted, (p1, p2) -> p1.getId().compareTo(p2.getId()));

                    String[] customerTransactionsNames = {"ID", "CUSTOMER ID", "PRODUCT ID", "AMOUNT"};
                    modelTransactionCustomer = new DefaultTableModel(customerTransactionsNames, 0);
                    for (int i = 0; i < isFormatted.size(); i++) {

                        Object[] objsTransactionCustomer = {isFormatted.get(i).getId(), isFormatted.get(i).getCustomerID(),
                            isFormatted.get(i).getProductID(),
                            isFormatted.get(i).getAmount()};

                        modelTransactionCustomer.addRow(objsTransactionCustomer);
                    }
                    
                    TableTransactionCustomer.setModel(modelTransactionCustomer);

                }

            }

        }

    }
    
    public void refreshAdmin(){
        //Making fields clear
        productIDTXT.setText("");
        productNameTXT.setText("");
        productDesTXT.setText("");
        productCatcomboBox.setSelectedIndex(0);
        productPriceTXT.setText("");
        productQuanTXT.setText("");
        
        userIDTXT.setText("");
        userFNameTXT.setText("");
        userLNameTXT.setText("");
        userPasswordTXT.setText("");
        
        customerIDTXT.setText("");
        customerFNameTXT.setText("");
        customerLNameTXT.setText("");
        
        productAmountTXT.setText("");
        
        //Refreshing comboBox
        setProductComboBox.removeAllItems();
        setProductComboBox.addItem("--No item selected--");
        ArrayList<Product> products = new ArrayList();
        products = client.getAllProducts();
        for(Product ans : products){
            setProductComboBox.addItem(ans.getId());
        }
        
        setUserComboBox.removeAllItems();
        setUserComboBox.addItem("--No item selected--");
        ArrayList<User> usersArray = new ArrayList();
        usersArray = client.getAllUsers();
        for(User ans : usersArray){
            setUserComboBox.addItem(ans.getId());
        }
        
        setCustomerComboBox.removeAllItems();
        setCustomerComboBox.addItem("--No item selected--");
        ArrayList<Customer> customerArray = new ArrayList();
        customerArray = client.getAllCustomers();
        Collections.sort(customerArray, (p1, p2) -> p1.getFname().compareTo(p2.getFname()));
        for(Customer ans : customerArray){
            setCustomerComboBox.addItem(ans.getId());
        }
        
        setUserProductComboBox.removeAllItems();
        setUserProductComboBox.addItem("--No item selected--");
        ArrayList<Product> userProductArray = new ArrayList();
        userProductArray = client.getAllProducts();
        Collections.sort(userProductArray, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        for(Product ans : userProductArray){
            setUserProductComboBox.addItem(ans.getId());
        }
        
        setCustomerTransactionComboBox.removeAllItems();
        setCustomerTransactionComboBox.addItem("--No item selected--");
        ArrayList<Customer> customerTransactionArray = new ArrayList();
        customerTransactionArray = client.getAllCustomers();
        Collections.sort(customerTransactionArray, (p1, p2) -> p1.getFname().compareTo(p2.getFname()));
        for(Customer ans : customerTransactionArray){
            setCustomerTransactionComboBox.addItem(ans.getId());
        }
        
        
        //Refreshing tables
        String[] columnNamesProduct = {"ID", "NAME", "DESCRIPTION", "CATEGORY", "PRICE", "QUANTITY"};
        ArrayList<Product> tableArrayProducts = new ArrayList<>();
        tableArrayProducts = client.getAllProducts();
        DefaultTableModel modelProducts = new DefaultTableModel(columnNamesProduct, 0);
        for(int i = 0; i < tableArrayProducts.size(); i++) {
            
            Object[] objsProducts = {tableArrayProducts.get(i).getId(), tableArrayProducts.get(i).getName(), tableArrayProducts.get(i).getDescription(), 
                tableArrayProducts.get(i).getCategory(), tableArrayProducts.get(i).getPrice(), tableArrayProducts.get(i).getQuantity()};
            modelProducts.addRow(objsProducts);
        }
        TableProduct.setModel(modelProducts);
        
        String[] columnNamesUser = {"ID", "FIRST NAME", "LAST NAME", "PASSWORD", "ACTIVE"};
        ArrayList<User> tableArrayUser = new ArrayList<>();
        tableArrayUser = client.getAllUsers();
        DefaultTableModel modelUser = new DefaultTableModel(columnNamesUser, 0);
        for(int i = 0; i < tableArrayUser.size(); i++) {
            
            Object[] objsUser = {tableArrayUser.get(i).getId(), tableArrayUser.get(i).getfName(), tableArrayUser.get(i).getlName(), 
                tableArrayUser.get(i).getPassword(), tableArrayUser.get(i).isActive()};
            
            modelUser.addRow(objsUser);
        }
        TableUser.setModel(modelUser);
        
        String[] columnNamesCustomer = {"ID", "FIRST NAME", "LAST NAME"};
        ArrayList<Customer> tableArrayCustomer = new ArrayList<>();
        tableArrayCustomer = client.getAllCustomers();
        DefaultTableModel modelCustomer = new DefaultTableModel(columnNamesCustomer, 0);
        for(int i = 0; i < tableArrayCustomer.size(); i++) {
            
            Object[] objsCustomer = {tableArrayCustomer.get(i).getId(), tableArrayCustomer.get(i).getFname(), tableArrayCustomer.get(i).getLname(),};
            
            modelCustomer.addRow(objsCustomer);
        }
         
        TableCustomer.setModel(modelCustomer);
        
        String[] columnNamesTransaction = {"ID", "CUSTOMER ID", "PRODUCT ID", "AMOUNT"};
        ArrayList<Transaction> tableArrayTransaction = new ArrayList<>();
        tableArrayTransaction = client.getAllTransactions();
        DefaultTableModel modelTransaction = new DefaultTableModel(columnNamesTransaction, 0);
        for(int i = 0; i < tableArrayTransaction.size(); i++) {
            
            Object[] objsTransaction = {tableArrayTransaction.get(i).getId(), tableArrayTransaction.get(i).getCustomerID(), tableArrayTransaction.get(i).getProductID(),
            tableArrayTransaction.get(i).getAmount()};
            
            modelTransaction.addRow(objsTransaction);
        }
         
        TableTransaction1.setModel(modelTransaction);

        String[] columnNamesTransactionPro = {"ID", "NAME", "DESCRIPTION", "CATEGORY", "PRICE", "QUANTITY"};
        ArrayList<Product> tableArrayTransactionPro = new ArrayList<>();
        tableArrayTransactionPro = client.getAllProducts();
        
        Collections.sort(tableArrayTransactionPro, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        
        DefaultTableModel modelTransactionPro = new DefaultTableModel(columnNamesTransactionPro, 0);
        for(int i = 0; i < tableArrayTransactionPro.size(); i++) {
            
            Object[] objsTransactionPro = {tableArrayTransactionPro.get(i).getId(), tableArrayTransactionPro.get(i).getName(), tableArrayTransactionPro.get(i).getDescription(),
            tableArrayTransactionPro.get(i).getCategory(), tableArrayTransactionPro.get(i).getPrice(), tableArrayTransactionPro.get(i).getQuantity()};
            
            modelTransactionPro.addRow(objsTransactionPro);
        }
        
        TableTransactionProducts.setModel(modelTransactionPro);

        
        
        String[] salesReportCol = {"PRODUCT", "PRODUCT PRICE", "AMOUNT SOLD", "SUB TOTAL"};
           
        ArrayList<Transaction> salesTransactions = new ArrayList<>();
        salesTransactions = client.getAllTransactions();
        
        ArrayList<Product> salesProducts = new ArrayList<>();
        salesProducts = client.getAllProducts();
        
        ArrayList<SalesReport> salesReports = new ArrayList<>();
        
        for(Product ans : salesProducts){
            salesReports.add(new SalesReport(ans.getId(), ans.getName(), ans.getPrice()));
        }
        
        for(Transaction ans : salesTransactions){
            for(SalesReport ans2 : salesReports){
                if(ans.getProductID().equals(ans2.getId())){
                    ans2.setAmount(ans2.getAmount() + ans.getAmount());
                }
            }
        }
        
        for(SalesReport ans : salesReports){
            ans.setTotal((int) (ans.getAmount() * ans.getProductPrice()));
        }
        
        
        Collections.sort(salesReports, (p1, p2) -> p1.getProduct().compareTo(p2.getProduct()));
        
        DefaultTableModel modelTransactionSales = new DefaultTableModel(salesReportCol, 0);
        for(int i = 0; i < salesReports.size(); i++) {
            
            Object[] objsTransactionCustomer = {salesReports.get(i).getProduct(), salesReports.get(i).getProductPrice(), 
                salesReports.get(i).getAmount(),
            salesReports.get(i).getTotal()};
            
            modelTransactionSales.addRow(objsTransactionCustomer);
        }
        
        
        TableTransactionSales.setModel(modelTransactionSales);
        
        int totalSalesRepport = 0;
         for(SalesReport ans : salesReports){
           totalSalesRepport = totalSalesRepport + ans.getTotal() ;
        }
        
        salesReportTotal2.setText("" + totalSalesRepport);
        
        
        //Making update fields clear
        
    }
    
    public static void main(String[] args) {
        new GUI().setGUI();
    }
    
}

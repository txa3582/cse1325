package mdi;

import store.Store;
import java.util.Scanner;

import javax.swing.text.View;


import store.Customer;
import store.Exposure;

import store.Tool;
import store.Order;
import store.Item;
import store.Plant;
import store.Product;

public class Controller
{
    //fields
    private Store store;
    private mdi.View view;
    private Menu mainMenu;
    private String output;
    private boolean isRunning;
    private Scanner in;

    public Controller(String storeName)
    {


        // load menuItem instances into menu field / setup main menu
        this.mainMenu = new Menu();
        mainMenu.addMenuItem(new MenuItem("0] Exit",                    () -> exit()));
        mainMenu.addMenuItem(new MenuItem("1] Place Order",             () -> placeOrder()));
        mainMenu.addMenuItem(new MenuItem("2] Welcome New Customer",    () -> newCustomer()));
        mainMenu.addMenuItem(new MenuItem("3] Define New Tool",         () -> newTool()));
        mainMenu.addMenuItem(new MenuItem("4] Define New Plant",        () -> newPlant()));
        mainMenu.addMenuItem(new MenuItem("5] Switch View",             () -> switchView()));


    }
    public void mdi() 
    {
        // System.err.println("====> Starting mdi");
        Integer selection = null;
        while(isRunning) 
        {
            // System.err.println("====> Start of main loop");
            try 
            {
                selection = selectFromMenu();
                output = "";
                if(selection == null) continue;
                if(selection == -1) testData();
                else mainMenu.run(selection);
            } 
            catch(Exception e) 
            {
                // e.printStackTrace();
                // getString("Press Enter to continue");
                print("#### Error: " + e.getMessage());
            }
        }
    }

    private void exit()
    {
        isRunning = false;
    }
    private void placeOrder()
    {
        String cList = store.getCustomerList();

        // Order newOrder = new store.newOrder();

    }
    private void newCustomer()
    {
        try
        {
            print("Enter name: \n");
            String name = getString(output);
            print("Enter email: \n");
            String email = getString(output);
            Customer newCustomer = new Customer(name, email);
            store.addCustomer(newCustomer);

            switchView();
            print("Added customer successfully!");
        }
        catch(Exception e)
        {
            System.err.println("Failed to add new customer");
        }
    }
    private void newTool()
    {
        try
        {
            print("Enter name: \n");
            String name = getString(output);
            print("Enter price: \n");
            String price = getString(output);
            int priceInt = getInt(price);
            Tool newTool = new Tool(name, priceInt);
            store.addProduct(newTool);
            
            print("Added tool successfully!");
            switchView();
        }
        catch(Exception e)
        {
            System.err.println("Failed to add new tool");
        }
        
    }
    private void newPlant()
    {
        try
        {
            print("Enter name: \n");
            String name = getString(output);
            print("Enter price: \n");
            String price = getString(output);
            int priceInt = getInt(price);
    
            Exposure exposure[] = Exposure.values();
            print("Enter exposure 1 = FULLSUN, 2 = PARTSUN and 3 = FULLSHADE \n");
            String exposureString = getString(output);
            int exposureInt = getInt(exposureString);
            Exposure exposureChoice = exposure[exposureInt];
    
            Plant newPlant = new Plant(name, priceInt, exposureChoice);
            store.addProduct(newPlant);

            print("Added plant successfully!");
            
            switchView();
        }
        catch(Exception e)
        {
            System.err.println("Failed to add new plant");
        }
        
    }
    private void switchView() 
    {
        System.out.println("\nSwitching View\n--------------\n");
        for(View view : View.values())
            System.out.println(view.ordinal() + "] " + view);
        int selection = getInt("\nSelection? ");
        view = View.values()[selection];
        print("Switched view to " + view);
    }
    private String getView() 
    {
        String result = "INVALID VIEW";
        if(view == View.CUSTOMERS) result = store.getCustomerList();
        if(view == View.PRODUCTS)  result = store.getProductList();
        if(view == View.ORDERS)    result = store.getOrderList();
        return result;
    }
    private int selectFromMenu()
    {
        for(int i = 0; i <= 20; i++)
            {
                print("\n");
            }
        print(store + " Main Menu" + '\n' + mainMenu);
        return getInt("Selection? ");
    }
    private void print(String s)
    {
        output.concat(s);
    }
    private String getString(String prompt)
    {
        print(prompt);
        String input;
        String inputTrimmed;

        while (true) 
        {
            
            try
            {
                input = in.nextLine();
                inputTrimmed = input.trim();

                return inputTrimmed;
            }
            catch(Exception e)
            {
                System.err.println("Invalid input!");
            }
        }
        
    }
    private int getInt(String prompt)
    {
        int userInt;
        while (true) 
        {
            try
            {
                userInt = Integer.parseInt(getString(prompt));

                return userInt;
            }
            catch(Exception e)
            {
                System.err.println("Invalid input!");
            }
        }
        
    }
    private double getDouble(String prompt)
    {
        double userDouble;
        while (true) 
        {
            try
            {
                userDouble = Double.parseDouble(getString(prompt));

                return userDouble;
            }
            catch(Exception e)
            {
                System.err.println("Invalid input!");
            }
        }
        
    }


public void testData() 
{
    Customer c1 = new Customer("Prof Rice", "george.rice@uta.edu");
    Customer c2 = new Customer("President Joe Biden", "president@whitehouse.gov");
    Customer c3 = new Customer("The Late Queen Elizabeth II", "queen@royal.gov.uk");
    Customer c4 = new Customer("Mark Zuckerberg", "mark.zuckerberg@facebook.com");
    store.addCustomer(c1);
    store.addCustomer(c2);
    store.addCustomer(c3);
    store.addCustomer(c4);

    Product p1 = new Plant("Cactus Cereus Peruvianus", 4990, Exposure.SUN);
    Product p2 = new Plant("'White Princess' Philodendron", 5500, Exposure.PARTSUN);
    Product p3 = new Tool("Bypass Pruners", 2299);
    Product p4 = new Tool("Large Gardener's Cart", 34900);
    store.addProduct(p1);
    store.addProduct(p2);
    store.addProduct(p3);
    store.addProduct(p4);
    
    int order = store.newOrder(0);
    store.addToOrder(order, 0, 4);
    store.addToOrder(order, 1, 3);
    store.addToOrder(order, 2, 2);
    store.addToOrder(order, 3, 1);
/*
    Item i1 = new Item(p1, 4);
    Item i2 = new Item(p2, 3);
    Item i3 = new Item(p3, 2);
    Item i4 = new Item(p4, 1);

    Order o1 = new Order(c1);
    o1.addItem(i1);
    o1.addItem(i2);
    o1.addItem(i3);
    o1.addItem(i4);
    store.addOrder(o1);
*/
}
}

package mdi;

import store.Store;
import store.Customer;
import store.Exposure;
import store.Tool;
import store.Plant;
import store.Product;
import store.Item;
import store.Order;

import java.util.Scanner;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Controller
{
    //fields
    private Store store;
    private mdi.View view;
    private Menu mainMenu;
    private String output;
    private boolean isRunning = true;
    private Scanner in;

    private String filename = "Untitled";

    public Controller(String storeName)
    {
        

        this.store = new Store(storeName);
        this.view = View.CUSTOMERS;
        this.isRunning = true;
        this.output = "";
        
        this.in = new Scanner(System.in);
        // load menuItem instances into menu field / setup main menu
        this.mainMenu = new Menu();

        mainMenu.addMenuItem(new MenuItem(" Exit",                    () -> exit()));
        mainMenu.addMenuItem(new MenuItem(" Place Order",             () -> placeOrder()));
        mainMenu.addMenuItem(new MenuItem(" Welcome New Customer",    () -> newCustomer()));
        mainMenu.addMenuItem(new MenuItem(" Define New Tool",         () -> newTool()));
        mainMenu.addMenuItem(new MenuItem(" Define New Plant",        () -> newPlant()));
        mainMenu.addMenuItem(new MenuItem(" Switch View",             () -> switchView()));
        mainMenu.addMenuItem(new MenuItem(" Save",                    () -> save()));
        mainMenu.addMenuItem(new MenuItem(" Save As",                 () -> saveAs()));
        mainMenu.addMenuItem(new MenuItem(" Open",                    () -> open()));


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
    //FILE methods
    private void save()
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename)))
        {
            store.save(bw);
            System.out.println("Wrote file to " + filename);

        }
        catch(Exception e)
        {
            System.err.println("Failed to save: " + e);
        }
    }
    private void saveAs()
    {
        System.out.println("Enter a filename to save: ");
        String s = in.nextLine();
        if(s.isEmpty()) return;
        filename = s;
        save();
    }
    private void open()
    {
        System.out.println("Enter a filename to open (Enter for '" +filename + "'): ");
        String s = in.nextLine();
        if(!s.isEmpty()) filename = s;
        try(BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            Store newStore = new Store(br);
            store = newStore;
            System.out.println("Opened store from " + filename);

        }
        catch(Exception e)
        {
            System.out.println("Failed to read: " + e);
        }
    }

    private String getView() 
    {
        String result = "INVALID VIEW";
        if(view == mdi.View.CUSTOMERS) result = store.getCustomerList();
        if(view == mdi.View.PRODUCTS)  result = store.getProductList();
        if(view == mdi.View.ORDERS)    result = store.getOrderList();
        return result;
    }

    private void exit()
    {
        isRunning = false;
    }
    private static final String clearScreen = "\n".repeat(255);
    private Integer selectFromMenu() 
    {
        System.out.println(clearScreen 
                         + store.getName() + " Main Menu\n\n" 
                         + mainMenu + '\n' 
                         + getView() + '\n'
                         + output + '\n');
        output = "";
        return getInt("Selection? ");
    }
    private void placeOrder() 
    {
        System.out.println("\nPlacing an Order\n----------------\n");
        int customer = getInt("\n" + store.getCustomerList() + "\nWhich Customer? ");
        if(customer < 0) return;
        int order = store.newOrder(customer);
        while(true) {
            int product = getInt("\n" + store.getProductList() 
                               + "\nWhich Product (-1 to complete order)? ");
            if(product < 0) break;
            int quantity = getInt("How many (-1 to select a different product)? ");
            if(quantity < 0) continue;
            store.addToOrder(order, product, quantity);
        }
        print("Created order " + order);
        view = mdi.View.ORDERS;
    }
    private void newCustomer() 
    {
        System.out.println("\nDefining a new Customer\n-----------------------\n");
        String name = getString("New Customer's name:  ");
        String email = getString("New Customer's email: ");
        Customer customer = new Customer(name, email);
        store.addCustomer(customer);
        print("Created new Customer: " + customer);
        view = mdi.View.CUSTOMERS; 
    }
    private void newTool() 
    {
        System.out.println("\nDefining a new Tool\n-------------------\n");
        String name = getString("New Tool's name:  ");
        double price = getDouble("New Tool's price: ");
        Tool tool = new Tool(name, (int) (price * 100));
        store.addProduct(tool);
        print("Created new Tool: " + tool);
        view = mdi.View.PRODUCTS; 
    }
    private void newPlant() 
    {
        System.out.println("\nDefining a new Plant\n-------------------\n");
        String name = getString("New Plant's name:  ");
        double price = getDouble("New Plant's price: ");

        
        Exposure exposure = null;
        try 
        {
            System.out.println();
            for(Exposure ex : Exposure.values())
                System.out.println(ex.ordinal() + "] " + ex);
            int selection = getInt("\nNew Plant's exposure? ");
            exposure = Exposure.values()[selection];
        } 
        catch(ArrayIndexOutOfBoundsException e) 
        {
            throw new ArrayIndexOutOfBoundsException("Invalid Exposure");
        }

        Plant plant = new Plant(name, (int) (price * 100), exposure);
        store.addProduct(plant);
        print("Created new Plant: " + plant);
        view = mdi.View.PRODUCTS; 
    }

    private void switchView() 
    {
        System.out.println("\nSwitching View\n--------------\n");
        for(mdi.View view : mdi.View.values())
            System.out.println(view.ordinal() + "] " + view);
        int selection = getInt("\nSelection? ");
        view = mdi.View.values()[selection];
        print("Switched view to " + view);
    }


    
   private void print(String s) 
    {
        output += s + '\n';
    }
    
    private String getString(String prompt)
    {
        
        String inputTrimmed;

        while (true) 
        {
            try
            {
                System.out.print(prompt);
                inputTrimmed = in.nextLine().trim();

                return inputTrimmed;
            }
            catch(Exception e)
            {
                System.err.println("Invalid input!");
            }
        }
        
    }
    private Integer getInt(String prompt) 
    {
        Integer i = null;
        while(true) {
            try 
            {
                String s = getString(prompt);
                if(s != null && !s.isEmpty()) i = Integer.parseInt(s);
                break;
            } 
            catch(Exception e) 
            {
                System.err.println("Invalid input!");
            }
        }
        return i;
    }
    private Double getDouble(String prompt) 
    {
        Double d = null;
        while(true) 
        {
            try  
            {
                String s = getString(prompt);
                if(s != null && !s.isEmpty()) d = Double.parseDouble(s);
                break;
            } 
            catch(Exception e) 
            {
                System.err.println("Invalid input!");
            }
        }
        return d;
    }


}

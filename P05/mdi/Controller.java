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
        int selected;
        try
        {
            while(isRunning == true)
            {
                selected = selectFromMenu();
                for(int i = 0; i <= 20; i++)
                {
                    print("\n");
                }
                int s = getInt(output);
                mainMenu.run(selected);
            }
        }
        catch (Exception e){}
        
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
        print("Switching View \n0] Customers \n1] Products \n2] Orders");
        getView();
    }
    private String getView()
    {
        int selection = getInt("Selection? ");
        
        mdi.View viewSelected = mdi.View.values()[selection];
        String list;
        
        if (viewSelected.equals(mdi.View.CUSTOMERS)) 
        {
            list = store.getCustomerList();
            return "" + list;
        }
        else if (viewSelected.equals(mdi.View.PRODUCTS)) 
        {
            list = store.getProductList();
            return "" + list;
        }
        else
        {
            list = store.getOrderList();
            return "" + list;
        }

        
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
}
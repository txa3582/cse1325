import java.util.Scanner;

import javax.swing.text.View;

import store.Customer;
import store.Store;
import store.Order;
public class Controller
{
    public Controller(String storeName)
    {
        this.store = store;
        this.view = view;
        this.in = in;
        this.isRunning = isRunning;
        this.output = output;

        mainMenu = new Menu();
        // load menuItem instances into menu field / setup main menu

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
                int s = getInt(output)
                mainMenu.run(selected);
            }
        }
        catch (Exception e){}
        
    }

    private void exit()
    {
        isRunning = false;
    }
    private placeOrder()
    {

    }
    private void newCustomer()
    {
        
        switchView(customers);
    }
    private newTool()
    {

    }
    private newPlant()
    {

    }
    private void switchView()
    {
        
    }
    private String getView()
    {
        return view.toString();
    }
    private int selectFromMenu()
    {
        for(int i = 0; i <= 20; i++)
            {
                print("\n");
            }
        print("Main Menu");
        return getInt(output);
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
                break;
            }
            catch(Exception e)
            {
                System.err.println("Invalid input!");
            }
        }
        return inputTrimmed;
    }
    private int getInt(String prompt)
    {
        int userInt;
        while (true) 
        {
            try
            {
                userInt = Integer.parseInt(getString(prompt));
                userInt = Integer.valueOf(userInt);
                break;
            }
            catch(Exception e)
            {
                System.err.println("Invalid input!");
            }
        }
        return userInt;
    }
    private double getDouble(String prompt)
    {
        double userDouble;
        while (true) 
        {
            try
            {
                userDouble = Double.parseDouble(getString(prompt));
                userDouble = Double.valueOf(userDouble);
                break;
            }
            catch(Exception e)
            {
                System.err.println("Invalid input!");
            }
        }
        return userDouble;
    }
    //fields
    private Store store;
    private View view;
    private Menu mainMenu;
    private String output;
    private boolean isRunning;
    private Scanner in;


}
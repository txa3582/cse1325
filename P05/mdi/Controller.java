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
        this.mainMenu = mainMenu;

        // load menuItem instances into menu field / setup main menu

    }
    public void mdi()
    {
        while(isRunning == true)
        {
            selectFromMenu();
            for(int i = 0; i <= 20; i++)
            {
                print("\n");
            }
            Menu.run();
        }
    }

    private void exit()
    {
        isRunning = false;
    }
    private placeOrder()
    {

    }
    private newCustomer()
    {

    }
    private newTool()
    {

    }
    private newPlant()
    {

    }
    private switchView()
    {

    }
    private String getView()
    {

    }
    private int selectFromMenu()
    {
        for(int i = 0; i <= 20; i++)
            {
                print("\n");
            }
        print("Main Menu");
        getInt(output);
    }
    private void print(String s)
    {
        
    }
    private String getString(String prompt)
    {
        print(prompt);
        
        String input = in.nextLine();
        
        return input.trim();
    }
    private int getInt(String prompt)
    {
        return 
    }
    private double getDouble(String prompt)
    {

    }
    //fields
    private Store store;
    private View view;
    private Menu mainMenu;
    private String output;
    private boolean isRunning;
    private Scanner in;


}
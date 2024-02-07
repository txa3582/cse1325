package store;

import java.util.ArrayList;

public class Order 
{
    public Order(Customer customer)
    {
        this.orderNumber = nextOrderNumber++;

        this.items = new ArrayList<>();
    }
    //methods
    public Item addItem(Item item)
    {
        items.add(item);
        return item;
    }
    int getPrice()
    {
        int sum = items.getPrice();
        return sum;
    }
    @Override
    public String toString() 
    {
        
    }

    //fields
    private static int nextOrderNumber = 0;
    private int orderNumber;
    private  ArrayList<Item> items;
    private Customer customer;

}

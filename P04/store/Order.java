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
        int sum = 0;
        for(int i = 0; i<items.size(); ++i)
        {
            int itemPrice = items.get(i).getPrice();
            sum = sum + itemPrice;
        }
        return sum;
    }
    @Override
    public String toString() 
    {
        return "Order #" + orderNumber + " for " + customer.toString()
        + items.toString()
        + "Order Total $ " + getPrice();
 
    }

    //fields
    private static int nextOrderNumber = 0;
    private int orderNumber;
    private  ArrayList<Item> items;
    private Customer customer;

}

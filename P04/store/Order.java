package store;

import java.util.ArrayList;

/**
 * Holds and processes an order for a customer. It then Prints a receipt.
 * 
 * @author          Thomas Anderson
 * @version         0.2
 * @since           0.2
 */

public class Order 
{
    /**
     * Creates a Customer instance.
     * 
     * @param customer      the customer           
     * @since               0.2
     */
    public Order(Customer customer)
    {
        this.orderNumber = nextOrderNumber++;

        this.items = new ArrayList<>();
    }
    //methods
    /**
     * Creates an Item instance and appends it to the ArrayList Items.
     * 
     * @param item          the item          
     * @return              the item
     * @since               0.2
     */
    public Item addItem(Item item)
    {
        items.add(item);
        return item;
    }
    /**
     * Calculates the total price of all items in the order.
     *             
     * @return              the sum of all the items
     * @since               0.2
     */
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
    /**
     * Outputs the order into a string.
     *        
     * @return              the order in a string format
     * @since               0.2
     */
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

// Copyright 2024 by Thomas Anderson
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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
        this.customer = customer;
    }
    public Order(BufferedReader br) throws IOException
	{
		try
		{
			this.orderNumber = Integer.parseInt(br.readLine());

            int sizeI = Integer.parseInt(br.readLine());
            this.items = new ArrayList<>();
            
            while(sizeI-- > 0) items.add(new Item(br));

            Customer customerRead = new Customer(br);
            this.customer = customerRead;
		}
		catch(Exception e)
		{
			System.err.println("Failed to read item file." + e);
		}
		

	}
	public void save(BufferedWriter bw) throws IOException
	{
		
		bw.write(orderNumber + '\n');
        bw.write("" + items.size() + '\n');
        for(Item i : items) 
        {
            bw.write(i.getClass().getName() + '\n');
            i.save(bw);
        }
		customer.save(bw);

	}
    //methods
    /**
     * Appends item to the ArrayList Items.
     * 
     * @param item          the item 
     * @since               0.2
     */
    public void addItem(Item item)
    {
        items.add(item);
    }
    /**
     * Calculates the total price of all items in the order.
     *             
     * @return              the sum of all the items
     * @since               0.2
     */
    public int getPrice()
    {
        int sum = 0;
        int itemPrice = 0;
        for(int i = 0; i<items.size(); ++i)
        {
            itemPrice = items.get(i).getPrice();
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
        StringBuilder itemsBuild = new StringBuilder();
        for(int i = 0; i<items.size(); i++)
        {
            itemsBuild.append(items.get(i));
        }
        int totalPrice = getPrice();

        String totalPriceFormatted = String.format("$ %5d.%02d", totalPrice/100, totalPrice%100);
        return "Order #" + orderNumber + " for " + customer.toString() + "\n"
        + itemsBuild + "\n" + "Order Total " + totalPriceFormatted + "\n";
 
    }

    //fields
    private static int nextOrderNumber = 1;
    private int orderNumber;
    private ArrayList<Item> items;
    private Customer customer;

}

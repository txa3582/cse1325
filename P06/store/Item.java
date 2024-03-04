// Copyright 2024 by Thomas Anderson
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Holds the product and the quantity of said product.
 * 
 * @author          Thomas Anderson
 * @version         0.2
 * @since           0.1
 */
public class Item
{
	 /**
	 * Creates a product and quantity instance.
	 * 
	 * @author          Thomas Anderson
	 * @param product 	the product class
	 * @param quantity	the item quantity 
	 * @version         0.2
	 * @since           0.1
	 */
	public Item(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
		
	}
	public Item(BufferedReader br) throws IOException
	{
		try
		{
			this.subClass = br.readLine();
			if(subClass.equals("store.Tool")) 
			{
				Tool tool = new Tool(br);
				this.product = tool;
			}
			else if(subClass.equals("store.Plant")) 
			{
				Plant plant = new Plant(br);
				this.product = plant;
			}

			this.quantity = Integer.parseInt(br.readLine());
		}
		catch(Exception e)
		{
			System.err.println("Failed to read item file." + e);
		}
		

	}
	public void save(BufferedWriter bw) throws IOException
	{
		
		bw.write(product.getClass().getName());
		bw.write("" + quantity + '\n');

	}
	/**
	 * Gets the price of item times the quantity ordered.
	 * 
	 * @author          Thomas Anderson
	 * @return			the price times the quantity of the item
	 * @version         0.2
	 * @since           0.1
	 */
	public int getPrice()
	{
		return quantity * product.getPrice();
	}
	/**
	 * Converts the item's price into a string.
	 * 
	 * @author          Thomas Anderson
	 * @return			the price of the item formatted
	 * @version         0.2
	 * @since           0.1
	 */
	@Override
	public String toString()
	{
		int price = getPrice();
		String itemFormat = String.format("%3d %-40s $ %5d.%02d", quantity, product, price/100, price%100);
		return itemFormat + "\n";
	}
	//fields
	private Product product;
	private int quantity;
	private String subClass;
	
}

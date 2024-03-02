package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Holds the Product info.
 * 
 * @author          Thomas Anderson
 * @version         0.2
 * @since           0.2
 */
public abstract class Product
{
	//constructors
	/**
	 * Creates a name and price instance.
	 * 
	 * @author          Thomas Anderson
	 * @param name		the product's name
	 * @param price		the product's price
	 * @version         0.2
	 * @since           0.1
	 */
	public Product(String name, int price)
	{
		//validate price
		if(price < 0) throw new IllegalArgumentException("Invalid price of " + name + ":" + price);

		this.stockNumber = nextStockNumber++;

		this.name = name;
		this.price = price;
	}
	public Product(BufferedReader br) throws IOException
	{
		this.name = br.readLine();
		this.price = Integer.parseInt(br.readLine());
		this.stockNumber = Integer.parseInt(br.readLine());
		this.nextStockNumber = Integer.parseInt(br.readLine());

	}
	public void save(BufferedWriter bw) throws IOException
	{
		bw.write(	name + '\n');
		bw.write("" + price + '\n');
		bw.write("" + stockNumber + '\n');
		bw.write("" + nextStockNumber + '\n');

	}
	/**
	 * Gets the stock number for that product.
	 * 
	 * @author          Thomas Anderson
	 * @return			the stocknumber of the product
	 * @version         0.2
	 * @since           0.1
	 */
	public int getStockNumber()
	{	
		return this.stockNumber;
	}
	/**
	 * Gets the price of the product.
	 * 
	 * @author          Thomas Anderson
	 * @return			the price of the product
	 * @version         0.2
	 * @since           0.1
	 */
	public int getPrice()
	{
		return this.price;	
	}
	//methods

	/**
	 * Converts the product's name and price into a formatted string.
	 * 
	 * @author          Thomas Anderson
	 * @return			the product's name and the price formatted.
	 * @version         0.2
	 * @since           0.1
	 */
	@Override
	public String toString()
	{
		name = String.format("%-30s",name);
		double priceConverted = price/100.0;
		String priceFormatted = String.format("$%,.2f", priceConverted);
		return name + "" + priceFormatted;
	}

	//fields
	private static int nextStockNumber = 0;
	private int stockNumber = 0;
	private String name;
	private int price;

}

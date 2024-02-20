package store;

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
	
}

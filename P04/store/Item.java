package store;

public class Item
{
	public Item(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
		
	}
	public int getPrice()
	{
		return quantity * product.getPrice();
	}
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

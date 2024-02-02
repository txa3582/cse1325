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
		int itemPrice = getPrice();
		String quantityFormatted = String.format("%3d", quantity); 
		String productFormatted = String.format("%-40s", product);	
		String itemPriceFormatted = String.format("$%05, 2f", itemPrice);
		return quantityFormatted + " " + productFormatted + " " + itemPriceFormatted;
	}
	//fields
	private Product product;
	private int quantity;
	
}

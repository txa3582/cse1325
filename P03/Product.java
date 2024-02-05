public class Product
{
	//constructors
	public Product(String name, int price)
	{
		//validate price
		if(price < 0) throw new IllegalArgumentException("Invalid price of " + name + ":" + price);

		stockNumber = nextStockNumber++;

		this.name = name;
		this.price = price;
	}

	public int getstockNumber()
	{	
		return stockNumber;
	}
	public int getPrice()
	{
		return price;	
	}
	//methods
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

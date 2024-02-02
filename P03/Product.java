public class Product
{
	//constructors
	public Product(String name, int price)
	{
		//validate price
		if(price < 0) throw new IllegalArgumentException("Invalid price " + name + ":" + price);

		stockNumber = 0;
		nextStockNumber = stockNumber;
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
		name = String.format("$-30s",name);
		String priceFormatted = String.format("$%, 2f", price);
		return name + priceFormatted;
	}
	//fields
	private int nextStockNumber;
	private int stockNumber;
	private String name;
	private int price;

}

public class Product
{
	//constructors
	public Product(String name, int price)
	{
		//validate price
		if(price < 0) throw new IllegalArgumentException("Invalid price " + name + ":" + price);

		nextStockNumber = (int) (100000000000.0 * Math.random()); 

		// Integer[] UPC;
		// UPC = new Integer[11];


		// for(int i = 0; i<UPC.length; ++i)
		// {
		// 	UPC[i] = (int) (100.0 * Math.random()); 
		// }
		//

		this.name = name;
		this.price = price;
	}

	public int getstockNumber()
	{	
		return '0' + nextStockNumber;
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

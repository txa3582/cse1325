public class Product
{
	//constructors
	public Product(String name, int price)
	{
		this.name = name;
		this.price = price;
		//validate price
		if(price < 0) throw new IllegalArgumentException("Invalid price " + name + ":" + price);

	}

	public int getstockNumber()
	{
		Integer[] UPC;
		UPC = new Integer[11];

		for(int i = 0; i<UPC.length; ++i)
		{
			UPC[i] = (int) (100.0 * Math.random()); 
		}

		
		
	}
	public int getPrice()
	{
		
	}
	//methods
	@Override
	public String toString()
	{

	}
	//fields
	private int nextStockNumber;
	private int stockNumber;
	private String name;
	private int price;

}

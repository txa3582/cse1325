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
	private int nextstockNumber;
	private String name;
	private int price;

}

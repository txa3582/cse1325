public class TestProduct
{
	public static void main(String[] args)
	{

		//Test1
		Product product1 = new Product("test name", 1111);
		Product product2 = new Product("test name", 2222);
		int testStock1 = product1.getstockNumber();	
		int testStock2 = product2.getstockNumber();
		if(testStock1 != 0)
			System.err.println("FAIL: first stock number is not 0");

		if(testStock2 != 1)
			System.err.println("FAIL: second stock number is not 1");
		//Test2
		int testPrice = product1.getPrice();
		if(testPrice != 1111)
			System.err.println("FAIL: getPrice is not returning the correct the price");
		//Test3

		//Test4
		// if(Product.getPrice() < 0) throw IllegalArgumentException("");
	}
}

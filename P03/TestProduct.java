public class TestProduct
{
	public static void main(String[] args)
	{

		//Test1
		Product product1 = new Product("test name", 1111);
		Product product2 = new Product("test name", 2222);
		int testStock1 = product1.getstockNumber();	
		int testStock2 = product2.getstockNumber();
		int error = 0;
		if(testStock1 != 0)
		{
			System.err.println("FAIL: first stock number is not 0");
			error++;
		}
		if(testStock2 != 1)
		{
			System.err.println("FAIL: second stock number is not 1");
			error++;
		}
		//Test2
		int testPrice = product1.getPrice();
		if(testPrice != 1111)
		{
			System.err.println("FAIL: getPrice is not returning the correct the price");
			error++;
		}
		//Test3
		String testString = product1.toString();
		System.out.println("" + testString);
		//Test4
		Product productNeg = new Product("test name", -1111);
		int testNegPrice = productNeg.getPrice();
		
		try
		{
			System.out.println("" + testNegPrice);
		}
		catch(IllegalArgumentException e)
		{

			System.err.println("" + testNegPrice);

			if(e.getMessage().isEmpty() || testNegPrice < 0)
			{
				System.err.println("FAIL: IllegalArguementException for negative price not being caught");
			}
		}
		catch(Exception misc)
		{

			System.err.println(misc.getMessage());
			System.err.println("FAIL: More than the expected Exception was caught");
			
			error++;
		}
		if(error != 0)
		{
			System.err.println("ERROR COUNT: " + error);
			System.exit(-1);
		}
		else
		{ 
			System.exit(0);
		}


		
		// if(Product.getPrice() < 0) throw IllegalArgumentException("");
	}
}

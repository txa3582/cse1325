package test;

// import store.Product;
import store.Tool;
import store.Customer;
import store.Exposure;
import store.Item;
import store.Order;
import store.Plant;
public class TestProduct
{
	public static void main(String[] args)
	{

		//Test1
		Tool product1 = new Tool("Shovel", 1111);
		Plant product2 = new Plant("Sunflower", 2222, Exposure.SUN);
		int testStock1 = product1.getStockNumber();	
		int testStock2 = product2.getStockNumber();
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
		// System.err.println(testString);
		String testStringExpected =	"Shovel                        $11.11";

		if(!testString.equals(testStringExpected))
		{
			System.err.println("FAIL: Product toString() not working correctly");
			error++;
		}
		Customer customer1 = new Customer("Gerald", "Gerald@email.com");
		Order order1 = new Order(customer1);
		Item testItem1 = new Item(product2, 4);
		Item testItem2 = new Item(product1, 3);
		order1.addItem(testItem1);
		order1.addItem(testItem2);

		
		String testOrderString1 = order1.toString();
		System.out.println(testOrderString1);

		//Test4
		
		boolean exceptionThrown = false;

		try
		{
			
			Tool productNeg = new Tool("test name", -1111);
			productNeg.getPrice();
		}
		catch(IllegalArgumentException e)
		{
			exceptionThrown = true;
		}
		catch(Exception misc)
		{

			System.err.println(misc.getMessage());
			System.err.println("FAIL: An unexpected Exception was caught");

			error++;
		}
		if(exceptionThrown == false)
		{
			System.err.println("FAIL: No exception was thrown for negative price");
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
		
	}
}

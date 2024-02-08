package test;

import store.Product;
import store.Tool;
import store.Exposure;
import store.Plant;
public class TestProduct
{
	public static void main(String[] args)
	{

		//Test1
		Tool product1 = new Tool("test name", 1111);
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
		String testStringExpected =	"test name                     $11.11";
		if(!testString.equals(testStringExpected))
		{
			System.err.println("FAIL: Product toString() not working correctly");
			error++;
		}
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
